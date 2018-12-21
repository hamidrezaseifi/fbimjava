package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.ProjectEdo;
import com.futurebim.common.model.edo.ProjectRoleEdo;
import com.futurebim.common.model.edo.ProjectUserEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.IProjectHandler;
import com.futurebim.core.bl.IProjectUserHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.ProjectRole;
import com.futurebim.core.model.ProjectUser;

@RestController
@RequestMapping(path = FbRestPaths.Core.PROJECT_BASE)
public class ProjectController {
  
  private IProjectHandler     projectHandler;
  private IProjectUserHandler projectUserHandler;
  
  @Autowired(required = true)
  public void setPersonService(final IProjectHandler projectReadHandler, final IProjectUserHandler projectUserHandler) {
    this.projectHandler = projectReadHandler;
    this.projectUserHandler = projectUserHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.PROJECT_READALLCOMPANY_BASE)
  public FBCollectionEdo<ProjectEdo> readAll(@PathVariable final Long companyId) throws StorageException {
    return new FBCollectionEdo<>(Project.toEdoList(projectHandler.listProjects(companyId)));
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.PROJECT_SAVE_BASE)
  public ProjectEdo createProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    return projectHandler.saveProject(Project.fromEdo(projectEdo)).toEdo();
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.PROJECT_READ_BASE)
  public ProjectEdo getProject(@PathVariable final Long projectId) throws StorageException {
    return projectHandler.getById(projectId).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.PROJECT_DELETE_BASE)
  public boolean deleteProject(@RequestBody final ProjectEdo projectEdo) throws StorageException {
    return projectHandler.deleteProject(Project.fromEdo(projectEdo));
  }

  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.PROJECTROLE_READALL_BASE)
  public FBCollectionEdo<ProjectRoleEdo> readAllRole(@PathVariable final Long companyId) throws StorageException {
    return new FBCollectionEdo<>(ProjectRole.toEdoList(projectHandler.listProjectRoles(companyId)));
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.PROJECTROLE_SAVE_BASE)
  public ProjectRoleEdo createProjectRole(@RequestBody(required = true) final ProjectRoleEdo roleEdo) throws StorageException {
    return projectHandler.saveProjectRole(ProjectRole.fromEdo(roleEdo)).toEdo();
  }

  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.PROJECTUSER_READALL_BASE)
  public FBCollectionEdo<ProjectUserEdo> readAllUsers(@PathVariable final Long projectId) throws StorageException {
    return new FBCollectionEdo<>(ProjectUser.toEdoList(projectUserHandler.listByProject(projectId)));
  }

  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.PROJECTUSER_SAVE_BASE)
  public ProjectUserEdo createProjectUser(@RequestBody(required = true) final ProjectUserEdo userEdo) throws StorageException {
    return projectUserHandler.save(ProjectUser.fromEdo(userEdo)).toEdo();
  }

  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.PROJECTUSER_DELETE_BASE)
  public void deleteProjectUser(@RequestBody(required = true) final ProjectUserEdo userEdo) throws StorageException {
    projectUserHandler.remove(ProjectUser.fromEdo(userEdo));
  }

}
