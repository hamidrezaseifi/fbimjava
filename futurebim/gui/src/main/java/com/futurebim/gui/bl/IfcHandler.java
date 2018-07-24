package com.futurebim.gui.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;
import com.futurebim.common.model.reponse.ProjectIfcRestResponse;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.helper.UiConfiguration;




@Service
public class IfcHandler {

  private final Logger logger = LoggerFactory.getLogger(IfcHandler.class);


  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;


  public ProjectIfcEdo getById(final Long id) {
    logger.debug("get projects list from core");

    ProjectIfcEdo ifcEdo = null;

    final String ifcUrl = coreAccessConfig.getIfcReadPath() + id.toString();
    
    logger.info("read ifc url:" + ifcUrl);

    final RestTemplate restTemplate = new RestTemplate();
    final ProjectIfcRestResponse responseBody = restTemplate.getForObject(ifcUrl,
        ProjectIfcRestResponse.class);

    if (responseBody.getProjectIfc() == null || responseBody.hasError()) {
      //throw new CustomerNotFoundException(messages.get("error.customergeterror"));
    }
    else
    {
      ifcEdo = responseBody.getProjectIfc();
    }

    return ifcEdo;
    

  }

  

}

