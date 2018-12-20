package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.ui.MenuItem;

@Controller
@RequestMapping(path = "/workflow")
public class WorkflowController extends UiControllerBase {
  
  @Autowired
  private PageMenuLoader pageMenuLoader;
  
  @RequestMapping(value = { "", "/", "/index" })
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());
    
    model.addAttribute("msg", "Workflow Index Page");
    
    return "workflow/index";
  }

  @RequestMapping(path = "/create")
  public String createProject(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    return "workflow/create";
  }
  
  @Override
  protected List<MenuItem> getTopToolbar() {
    
    return pageMenuLoader.getTopMenus("menu.workflow");
  }
  
  @Override
  protected List<MenuItem> getLeftToolbar() {
    
    final List<MenuItem> menus = new ArrayList<>();

    MenuItem m = new MenuItem("menu.index", messagesHelper.get("workflow.workflow-list"), "list", "/workflow");

    m.setActive(false);
    if (getCurrentRelatedUrl().equals("/workflow") || getCurrentRelatedUrl().equals("/workflow/") || getCurrentRelatedUrl().equals("/workflow/index")) {
      m.setActive(true);
    }
    menus.add(m);

    m = new MenuItem("menu.create", messagesHelper.get("workflow.workflow-create"), "playlist_add", "/workflow/create");

    m.setActive(false);
    if (getCurrentRelatedUrl().equals(m.getUrl())) {
      m.setActive(true);
    }
    menus.add(m);

    return menus;
  }
  
  @Override
  protected String getActiveLeftToolbarId() {
    
    return "";
  }
}
