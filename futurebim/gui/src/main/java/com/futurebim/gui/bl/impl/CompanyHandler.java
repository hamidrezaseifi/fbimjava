package com.futurebim.gui.bl.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.ICompanyHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiCompany;

@Service
public class CompanyHandler implements ICompanyHandler {

  private final Logger logger = LoggerFactory.getLogger(UserHandler.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  @Override
  public GuiCompany getById(final Long id) {
    logger.debug("get company from core");
    
    final CompanyEdo edo = restTemplateCall.callRestGet(coreAccessConfig.getCompanyRead(), EModule.CORE, CompanyEdo.class, true, id);

    return GuiCompany.fromEdo(edo);
  }
  
  @Override
  public GuiCompany save(final GuiCompany company) {
    logger.debug("update company in core");
    final CompanyEdo edo = restTemplateCall.callRestPost(coreAccessConfig.getCompanyUpdate(), EModule.CORE, company.toEdo(), CompanyEdo.class, true);
    return GuiCompany.fromEdo(edo);
  }

}
