package com.featurebim.core.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.IProjectHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

  private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

  private IProjectHandler projectHandler;

  @Autowired(required = true)
  public void setPersonService(final IProjectHandler projectReadHandler) {
    this.projectHandler = projectReadHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/all/{companyId}")
  public List<ProjectEdo> readAll(@PathVariable final Long companyId) throws StorageException {
    logger.debug("read projects list");
    return Project.toEdoList(projectHandler.listProjects(companyId));
  }

  @FbCoreRequestPostDataMapping(value = "/create")
  public ProjectEdo createProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    logger.debug("read projects list");
    return projectHandler.addProject(Project.fromEdo(projectEdo)).toEdo();
  }

  @FbCoreRequestPostDataMapping(value = "/update")
  public ProjectEdo updateProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    logger.debug("read projects list");
    return projectHandler.updateProject(Project.fromEdo(projectEdo)).toEdo();
  }

  @FbCoreRequestGetDataMapping(value = "/read/{projectId}")
  public ProjectEdo getProject(@PathVariable final Long projectId) throws StorageException {
    logger.debug("read projects list");
    return projectHandler.getById(projectId).toEdo();
  }

}
