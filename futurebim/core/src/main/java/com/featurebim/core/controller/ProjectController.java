package com.featurebim.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.model.reponse.GeneralRestResponse;
import com.featurebim.common.model.reponse.ProjectListRestResponse;
import com.featurebim.common.model.reponse.ProjectRestResponse;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.ProjectHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

  private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

  private ProjectHandler projectHandler;

  @Autowired(required = true)
  public void setPersonService(final ProjectHandler projectReadHandler) {
    this.projectHandler = projectReadHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/all/{companyId}")
  public ProjectListRestResponse readAll(@PathVariable final Long companyId) throws StorageException {
    logger.debug("read projects list");
    return ProjectListRestResponse.createList(Project.toEdoList(projectHandler.listProjects(companyId)));
  }

  @FbCoreRequestPostDataMapping(value = "/create")
  public GeneralRestResponse createProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    logger.debug("read projects list");
    return GeneralRestResponse.createData(projectHandler.addProject(Project.fromEdo(projectEdo)));
  }

  @FbCoreRequestPostDataMapping(value = "/update")
  public GeneralRestResponse updateProject(@RequestBody(required = true) final ProjectEdo projectEdo) throws StorageException {
    logger.debug("read projects list");
    return GeneralRestResponse.createData(projectHandler.updateProject(Project.fromEdo(projectEdo)));
  }

  @FbCoreRequestGetDataMapping(value = "/read/{projectId}")
  public ProjectRestResponse getProject(@PathVariable final Long projectId) throws StorageException {
    logger.debug("read projects list");
    return ProjectRestResponse.createData(projectHandler.getById(projectId).toEdo());
  }

}
