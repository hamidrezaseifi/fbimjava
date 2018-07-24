package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.futurebim.gui.bl.IfcHandler;
import com.futurebim.gui.bl.ProjectsHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.helper.UiConfiguration.CoreAccessConfig;
import com.futurebim.gui.model.MenuItem;
import com.futurebim.gui.model.futurebim.GuiProjectRich;
import com.futurebim.gui.model.futurebim.ifc.GuiProjectIfc;
import com.futurebim.gui.restresponse.GuiProjectIfcRestResponse;
import com.futurebim.gui.service.GuiLoggedDataService;

@Controller
@RequestMapping(path = "/ifc")
public class IfcViewerController extends UiControllerBase {
  
  @Autowired
  private PageMenuLoader pageMenuLoader;
  
  @Autowired
  ProjectsHandler projectsHandler;
  
  @Autowired
  IfcHandler ifcHandler;
  
  @Autowired
  private CoreAccessConfig coreAccessConfig;
  
  @Autowired
  GuiLoggedDataService guiLoggedDataService;
  
  @Autowired
  ObjectMapper objectMapper;
  
  @RequestMapping(path = "/")
  public String index(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());
    
    model.addAttribute("msg" , "IFC Viewer Index Page");
    model.addAttribute("loadIfcUrl" , coreAccessConfig.getIfcReadPath());
    
    if(guiLoggedDataService.isLoggedIn()){
      model.addAttribute("projects" , projectsHandler.listProjects(guiLoggedDataService.getLoggedData().getUser().getCompanyid()));
    }
    else{
      model.addAttribute("projects" , projectsHandler.listProjects(0L));
    }
    
    return "ifcviewer/index";
  }
  
  @RequestMapping(value = "/getjson/{ifcId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody GuiProjectIfcRestResponse getIfcJson(@PathVariable final Long ifcId) {
    
    final GuiProjectIfcRestResponse response = GuiProjectIfcRestResponse.createData(new GuiProjectIfc(ifcHandler.getById(ifcId)));
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    
    return response;
  }
  
  @RequestMapping(value = "/data/projects/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<GuiProjectRich> readAll() {
    
    List<GuiProjectRich> list = null;
    
    if(guiLoggedDataService.isLoggedIn()){
      list = projectsHandler.listProjects(guiLoggedDataService.getLoggedData().getUser().getCompanyid());
    }
    else{
      list = projectsHandler.listProjects(0L);
    }
    
    return list;
  }
  
  
  
  
  @Override
  protected String getActiveLeftToolbarId() {
    
    
    return "";
  }
  
  @Override
  protected List<MenuItem> getTopToolbar() {
    
    return pageMenuLoader.getTopMenus("menu.ifc");
  }
  
  @Override
  protected List<MenuItem> getLeftToolbar() {
    
    return new ArrayList<>(); //pageMenuLoader.getLeftMenus("/ifc", getActiveLeftToolbarId());
  }
  
}
