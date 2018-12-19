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
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.IProjectHandler;
import com.futurebim.core.bl.IProjectUserHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.ProjectRole;
import com.futurebim.core.model.ProjectUser;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

  private IProjectHandler     projectHandler;
  private IProjectUserHandler projectUserHandler;

  @Autowired(required = true)
  public void setPersonService(final IProjectHandler projectReadHandler, final IProjectUserHandler projectUserHandler) {
    this.projectHandler = projectReadHandler;
    this.projectUserHandler = projectUserHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/comapny/readall/{companyId}")
  public FBCollectionEdo<ProjectEdo> readAll(@PathVariable final Long companyId) throws StorageException {
    return new FBCollectionEdo<>(Project.toEdoList(projectHandler.listProjects(companyId)));
  }

  @FbCoreRequestPostDataMapping(value = "/save")
  public ProjectEdo createProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    return projectHandler.saveProject(Project.fromEdo(projectEdo)).toEdo();
  }

  @FbCoreRequestGetDataMapping(value = "/read/{projectId}")
  public ProjectEdo getProject(@PathVariable final Long projectId) throws StorageException {
    return projectHandler.getById(projectId).toEdo();
  }

  @FbCoreRequestPostDataMapping(value = "/delete")
  public boolean deleteProject(@RequestBody final ProjectEdo projectEdo) throws StorageException {
    return projectHandler.deleteProject(Project.fromEdo(projectEdo));
  }
  
  @FbCoreRequestGetDataMapping(value = "/role/readall/{companyId}")
  public FBCollectionEdo<ProjectRoleEdo> readAllRole(@PathVariable final Long companyId) throws StorageException {
    return new FBCollectionEdo<>(ProjectRole.toEdoList(projectHandler.listProjectRoles(companyId)));
  }

  @FbCoreRequestPostDataMapping(value = "/role/save")
  public ProjectRoleEdo createProjectRole(@RequestBody(required = true) final ProjectRoleEdo roleEdo) throws StorageException {
    return projectHandler.saveProjectRole(ProjectRole.fromEdo(roleEdo)).toEdo();
  }
  
  @FbCoreRequestGetDataMapping(value = "/user/readall/{projectId}")
  public FBCollectionEdo<ProjectUserEdo> readAllUsers(@PathVariable final Long projectId) throws StorageException {
    return new FBCollectionEdo<>(ProjectUser.toEdoList(projectUserHandler.listByProject(projectId)));
  }
  
  @FbCoreRequestPostDataMapping(value = "/user/save")
  public ProjectUserEdo createProjectUser(@RequestBody(required = true) final ProjectUserEdo userEdo) throws StorageException {
    return projectUserHandler.save(ProjectUser.fromEdo(userEdo)).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = "/user/delete")
  public void deleteProjectUser(@RequestBody(required = true) final ProjectUserEdo userEdo) throws StorageException {
    projectUserHandler.remove(ProjectUser.fromEdo(userEdo));
  }
  
}
