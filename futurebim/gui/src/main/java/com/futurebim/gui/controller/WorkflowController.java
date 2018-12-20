package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.futurebim.gui.bl.IProjectsHandler;
import com.futurebim.gui.bl.IWorkflowHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.futurebim.GuiProject;
import com.futurebim.gui.model.futurebim.GuiWorkflow;
import com.futurebim.gui.model.ui.MenuItem;

@Controller
@RequestMapping(path = "/workflow")
public class WorkflowController extends UiControllerBase {
  
  @Autowired
  private PageMenuLoader pageMenuLoader;

  @Autowired
  private IProjectsHandler projectsHandler;

  @Autowired
  private IWorkflowHandler workflowHandler;
  
  @RequestMapping(value = { "", "/", "/index" })
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());
    
    final List<GuiProject> list = projectsHandler.listProjects(this.getCurrentCompany().getId());
    model.addAttribute("projects", list);
    model.addAttribute("firstProjectId", list.size() > 0 ? list.get(0).getId() : 0);
    
    return "workflow/index";
  }

  @RequestMapping(path = "/create")
  public String createProject(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    return "workflow/create";
  }

  @RequestMapping(path = "/view/{projectid}")
  public String viewProject(@PathVariable(name = "projectid") final long projectid, final Model model) {

    return "workflow/view";
  }
  
  @RequestMapping(path = "/update/{projectid}")
  public String editProject(@PathVariable(name = "projectid") final long projectid, final Model model) {

    return "workflow/update";
  }
  
  @RequestMapping(path = "/delete/{projectid}")
  public String deleteProject(@PathVariable(name = "projectid") final long projectid, final Model model) {

    return "workflow/delete";
  }
  
  @FbGuiRequestGetDataMapping(value = "/data/list/{projectid}")
  public List<GuiWorkflow> listProjectWorkflows(@PathVariable(name = "projectid") final long projectid) {
    
    return workflowHandler.list(projectid);
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
