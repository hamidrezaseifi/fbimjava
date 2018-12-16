package com.featurebim.gui.bl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.common.model.edo.ProjectCollectionEdo;
import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.model.enums.EModule;
import com.featurebim.gui.configuration.UiConfiguration;
import com.featurebim.gui.helper.IUiRestTemplateCall;
import com.featurebim.gui.helper.MessagesHelper;
import com.featurebim.gui.model.futurebim.GuiProject;

@Service
public class ProjectsHandler implements IProjectsHandler {

  private final Logger logger = LoggerFactory.getLogger(ProjectsHandler.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;
  
  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  @Autowired
  private IValueHandler valueHandler;

  @Override
  public GuiProject getById(final Long id) {
    logger.debug("get projects list from core");
    
    logger.info("url:" + coreAccessConfig.getProjectReadPath());
    
    final ProjectEdo projectEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectReadPath(), EModule.CORE, ProjectEdo.class, true, id);
    
    final GuiProject project = GuiProject.fromEdo(projectEdo);
    
    return prepareProject(project);
  }

  @Override
  public List<GuiProject> listProjects(final Long companyId) {

    logger.debug("get projects list from core");

    logger.info("url:" + coreAccessConfig.getProjectReadAllPath());

    final ProjectCollectionEdo projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getProjectReadAllPath(), EModule.CORE, ProjectCollectionEdo.class, true, companyId);
    
    final List<GuiProject> list = GuiProject.fromEdoList(projectsEdo.getProjects());

    for (final GuiProject project : list) {
      prepareProject(project);
    }
    return list;
  }

  private GuiProject prepareProject(final GuiProject project) {
    project.setProjectTypeName(valueHandler.getProjectTypeName(project.getProjectType()));
    project.setStatusName(valueHandler.getProjectStatusName(project.getStatus()));
    
    return project;
  }
  
  @Override
  public GuiProject save(final GuiProject project) {
    logger.debug("save projects into core");

    logger.info("url:" + coreAccessConfig.getProjectSavePath());

    final ProjectEdo projectEdo = restTemplateCall.callRestPost(coreAccessConfig.getProjectSavePath(), EModule.CORE, project.toEdo(), ProjectEdo.class, true);
    
    return GuiProject.fromEdo(projectEdo);
  }

}
