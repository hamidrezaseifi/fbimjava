package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.SystemMenuItemEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.bl.ISystemMenuHandler;

@RestController
@RequestMapping(path = FbRestPaths.Core.SYSTEMMENU_BASE)
public class SystemMenuController {
  
  private ISystemMenuHandler systemMenuHandler;
  
  @Autowired(required = true)
  public void setPersonService(final ISystemMenuHandler systemMenuHandler) {
    this.systemMenuHandler = systemMenuHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.SYSTEMMENU_ALLLIST_BASE)
  public SystemMenuItemEdo getAllMenuList() throws Exception {
    
    return systemMenuHandler.getRootMenu().toEdo();
  }
  
}
