package com.futurebim.gui.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.futurebim.common.model.reponse.ProjectListRestResponse;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.helper.UiConfiguration;
import com.futurebim.gui.model.futurebim.GuiProjectRich;




@Service
public class ProjectsHandler {
  
  private final Logger logger = LoggerFactory.getLogger(ProjectsHandler.class);
  
  
  @Autowired
  MessagesHelper messages;
  
  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;
  
  
  public GuiProjectRich getById(final Long id) {
    return null;
    
  }
  
  public List<GuiProjectRich> listProjects(final Long companyId) {
    
    
    logger.debug("get projects list from core");
    
    List<GuiProjectRich> list = new ArrayList<>();
    
    
    logger.info("url:" + coreAccessConfig.getAllProjectsReadPath("/read/all/" + companyId));
    
    final RestTemplate restTemplate = new RestTemplate();
    final ProjectListRestResponse responseBody = restTemplate.getForObject(coreAccessConfig.getAllProjectsReadPath(companyId.toString()),
        ProjectListRestResponse.class);
    
    if (responseBody.getProjects() == null || responseBody.hasError()) {
      //throw new CustomerNotFoundException(messages.get("error.customergeterror"));
    }
    else
    {
      list = GuiProjectRich.fromEdoList(responseBody.getProjects()) ;
    }
    
    return list;
  }
  
}

