package com.featurebim.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.reponse.ProjectListRestResponse;
import com.featurebim.common.model.reponse.ProjectRestResponse;
import com.featurebim.core.bl.ProjectHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

  private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

  private ProjectHandler projectReadHandler;

  @Autowired(required = true)
  public void setPersonService(final ProjectHandler projectReadHandler) {
    this.projectReadHandler = projectReadHandler;
  }

  @RequestMapping(value = "/all/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody ProjectListRestResponse readAll(@PathVariable final Long companyId) throws StorageException {
    logger.debug("read projects list");
    return ProjectListRestResponse.createList(Project.toEdoList(projectReadHandler.listProjects(companyId)));
  }

  @RequestMapping(value = "/read/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody ProjectRestResponse getProject(@PathVariable final Long projectId) throws StorageException {
    logger.debug("read projects list");
    return ProjectRestResponse.createData(projectReadHandler.getById(projectId).toEdo());
  }

}
