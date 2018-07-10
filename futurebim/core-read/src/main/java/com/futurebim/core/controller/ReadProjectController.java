package com.futurebim.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.reponse.ProjectListRestResponse;
import com.futurebim.core.bl.ProjectReadHandler;
import com.futurebim.core.model.ProjectRich;

@RestController
@RequestMapping(path = "/project/read")
public class ReadProjectController {

  private final Logger logger = LoggerFactory.getLogger(ReadProjectController.class);

  private ProjectReadHandler projectReadHandler;

  @Autowired(required = true)
  public void setPersonService(final ProjectReadHandler projectReadHandler) {
    this.projectReadHandler = projectReadHandler;
  }

  @RequestMapping(value = "/all/{companyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody ProjectListRestResponse readAll(@PathVariable final Long companyId) {
    logger.debug("read projects list");
    return ProjectListRestResponse.createList(ProjectRich.toEdoList(projectReadHandler.listProjects(companyId)));
  }

}
