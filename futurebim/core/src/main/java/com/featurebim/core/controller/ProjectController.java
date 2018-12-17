package com.featurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.ProjectCollectionEdo;
import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.IProjectHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {
  
  private IProjectHandler projectHandler;
  
  @Autowired(required = true)
  public void setPersonService(final IProjectHandler projectReadHandler) {
    this.projectHandler = projectReadHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = "/comapny/readall/{companyId}")
  public ProjectCollectionEdo readAll(@PathVariable final Long companyId) throws StorageException {
    return new ProjectCollectionEdo(Project.toEdoList(projectHandler.listProjects(companyId)));
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
  
}
