package com.featurebim.gui.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.featurebim.common.model.reponse.ProjectListRestResponse;
import com.featurebim.gui.configuration.UiConfiguration;
import com.featurebim.gui.helper.MessagesHelper;
import com.featurebim.gui.model.futurebim.GuiProject;

@Service
public class ProjectsHandler {

  private final Logger logger = LoggerFactory.getLogger(ProjectsHandler.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;

  public GuiProject getById(final Long id) {
    return null;

  }

  public List<GuiProject> listProjects(final Long companyId) {

    logger.debug("get projects list from core");

    List<GuiProject> list = new ArrayList<>();

    logger.info("url:" + coreAccessConfig.getAllProjectsReadPath());

    final RestTemplate restTemplate = new RestTemplate();
    final ProjectListRestResponse responseBody = restTemplate.getForObject(coreAccessConfig.getAllProjectsReadPath(),
                                                                           ProjectListRestResponse.class);

    if (responseBody.getProjects() == null || responseBody.hasError()) {
      // throw new CustomerNotFoundException(messages.get("error.customergeterror"));
    }
    else {
      list = GuiProject.fromEdoList(responseBody.getProjects());
    }

    return list;
  }

}
