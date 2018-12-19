package com.futurebim.gui.bl.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.ProjectEdo;
import com.futurebim.common.model.edo.ProjectRoleEdo;
import com.futurebim.common.model.edo.ProjectUserEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.IProjectsHandler;
import com.futurebim.gui.bl.ITaskHandler;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IValueHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiProject;
import com.futurebim.gui.model.futurebim.GuiProjectRole;
import com.futurebim.gui.model.futurebim.GuiProjectUser;
import com.futurebim.gui.model.ui.UiSessionUserInfo;

@Service
public class ProjectsHandler implements IProjectsHandler {

  private final Logger logger = LoggerFactory.getLogger(ProjectsHandler.class);

  @Autowired
  MessagesHelper messagesHelper;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;
  
  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  @Autowired
  private IValueHandler valueHandler;
  
  @Autowired
  private IUserHandler userHandler;

  @Autowired
  private ITaskHandler taskHandler;

  @Autowired
  private UiSessionUserInfo sessionUserInfo;
  
  @Override
  public GuiProject getById(final Long id) {
    logger.debug("get projects list from core");
    
    final ProjectEdo projectEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectReadPath(), EModule.CORE, ProjectEdo.class, true, id);
    
    final GuiProject project = GuiProject.fromEdo(projectEdo);
    
    return prepareProject(project);
  }

  @Override
  public List<GuiProject> listProjects(final Long companyId) {

    logger.debug("get projects list from core");

    final ParameterizedTypeReference<FBCollectionEdo<ProjectEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<ProjectEdo>>() {
    };

    final FBCollectionEdo<ProjectEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectReadAllPath(), EModule.CORE, typeRef, true, companyId);
    
    final List<GuiProject> list = GuiProject.fromEdoList(projectsEdo.getItems());

    for (final GuiProject project : list) {
      prepareProject(project);
    }
    return list;
  }

  private GuiProject prepareProject(final GuiProject project) {
    project.setProjectTypeName(valueHandler.getProjectTypeName(project.getProjectType()));
    project.setStatusName(valueHandler.getProjectStatusName(project.getStatus()));
    project.setUsers(listProjectUsers(project.getId()));
    project.setTasks(taskHandler.listTasks(project.getId()));

    return project;
  }
  
  @Override
  public GuiProject save(final GuiProject project) {
    logger.debug("save projects into core");

    final ProjectEdo projectEdo = restTemplateCall.callRestPost(coreAccessConfig.getProjectSavePath(), EModule.CORE, project.toEdo(), ProjectEdo.class, true);
    
    return GuiProject.fromEdo(projectEdo);
  }

  @Override
  public boolean delete(final GuiProject project) {
    logger.debug("save projects into core");
    
    restTemplateCall.callRestPost(coreAccessConfig.getProjectDeletePath(), EModule.CORE, project.toEdo(), Void.class, true);
    
    return true;
  }

  @Override
  public List<GuiProjectRole> listProjectRoles(final Long companyId) {
    logger.debug("get project roles list from core");

    final ParameterizedTypeReference<FBCollectionEdo<ProjectRoleEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<ProjectRoleEdo>>() {
    };

    final FBCollectionEdo<ProjectRoleEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectRoleReadAllPath(), EModule.CORE, typeRef, true, companyId);
    
    final List<GuiProjectRole> list = GuiProjectRole.fromEdoList(projectsEdo.getItems());
    list.add(new GuiProjectRole(0, messagesHelper.get("project.norole")));
    
    return list;
  }

  @Override
  public GuiProjectRole saveProjectRole(final GuiProjectRole role) {
    logger.debug("save project role into core");

    final ProjectRoleEdo roleEdo = restTemplateCall.callRestPost(coreAccessConfig.getProjectRoleSavePath(), EModule.CORE, role.toEdo(), ProjectRoleEdo.class, true);
    
    return GuiProjectRole.fromEdo(roleEdo);
  }

  @Override
  public List<GuiProjectUser> listProjectUsers(final Long projectId) {
    logger.debug("get project users list from core");

    final ParameterizedTypeReference<FBCollectionEdo<ProjectUserEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<ProjectUserEdo>>() {
    };

    final FBCollectionEdo<ProjectUserEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectUserReadAllPath(), EModule.CORE, typeRef, true, projectId);
    
    final List<GuiProjectUser> list = GuiProjectUser.fromEdoList(projectsEdo.getItems());
    
    for (final GuiProjectUser puser : list) {
      prepareGuiProjectUser(puser);
    }

    return list;
  }

  @Override
  public GuiProjectUser saveProjectUser(final GuiProjectUser projectUser) {
    logger.debug("save project user into core");

    final ProjectUserEdo projectUserEdo = restTemplateCall.callRestPost(coreAccessConfig.getProjectUserSavePath(), EModule.CORE, projectUser.toEdo(), ProjectUserEdo.class, true);
    
    return prepareGuiProjectUser(GuiProjectUser.fromEdo(projectUserEdo));
  }

  @Override
  public boolean deleteProjectUser(final GuiProjectUser projectUser) {
    logger.debug("delete project user into core");

    restTemplateCall.callRestPost(coreAccessConfig.getProjectUserDeletePath(), EModule.CORE, projectUser.toEdo(), Void.class, true);
    
    return true;
  }

  private GuiProjectUser prepareGuiProjectUser(final GuiProjectUser pUser) {
    return pUser.setUser(userHandler.getById(pUser.getUserId())).setRole(sessionUserInfo.getProjectRoleById(pUser.getRoleId())).setAccessTypeName(getProjectAccessTypeName(pUser.getAccessType()));
  }

  @Override
  public String getProjectAccessTypeName(final int accessType) {

    return messagesHelper.get("project.accesstypename" + accessType);
  }

}
