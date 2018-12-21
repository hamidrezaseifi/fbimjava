package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.futurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.futurebim.gui.bl.IProjectsHandler;
import com.futurebim.gui.bl.ITaskHandler;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IWorkflowHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.FbIdNamePair;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.futurebim.GuiProject;
import com.futurebim.gui.model.futurebim.GuiTask;
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

  @Autowired
  private ITaskHandler taskHandler;
  
  @Autowired
  private IUserHandler userHandler;
  
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

  @RequestMapping(path = "/view/{workflowid}")
  public String viewProject(@PathVariable(name = "workflowid") final long workflowid, final Model model) {

    final GuiWorkflow workflow = workflowHandler.getById(workflowid);
    
    final List<FbIdNamePair> statusList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      statusList.add(new FbIdNamePair(i, workflowHandler.getWorkflowStatusName(i)));
    }
    model.addAttribute("workflow", workflow);
    model.addAttribute("projectId", workflow.getProjectid());
    model.addAttribute("types", workflowHandler.listTypes());
    model.addAttribute("statusList", statusList);
    model.addAttribute("projectUsers", projectsHandler.listProjectUsers(workflow.getProjectid()));
    model.addAttribute("allUsers", userHandler.listCompanyUsers(this.getCurrentCompany().getId()));

    return "workflow/view";
  }
  
  @RequestMapping(path = "/update/{workflowid}")
  public String editProject(@PathVariable(name = "workflowid") final long workflowid, final Model model) {

    final GuiWorkflow workflow = workflowHandler.getById(workflowid);
    
    final List<FbIdNamePair> statusList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      statusList.add(new FbIdNamePair(i, workflowHandler.getWorkflowStatusName(i)));
    }
    model.addAttribute("workflow", workflow);
    model.addAttribute("projectId", workflow.getProjectid());
    model.addAttribute("types", workflowHandler.listTypes());
    model.addAttribute("statusList", statusList);
    model.addAttribute("projectUsers", projectsHandler.listProjectUsers(workflow.getProjectid()));
    model.addAttribute("allUsers", userHandler.listCompanyUsers(this.getCurrentCompany().getId()));
    
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
  
  @FbGuiRequestGetDataMapping(value = "/data/workflow/read/{workflowid}")
  public GuiWorkflow readWorkflows(@PathVariable(name = "workflowid") final long workflowid) {
    
    return workflowHandler.getById(workflowid);
  }
  
  @FbGuiRequestPostDataMapping(value = "/data/workflow/save")
  public GuiWorkflow saveWorkflow(@RequestBody final GuiWorkflow workflow) {
    
    return workflowHandler.save(workflow);
  }
  
  @FbGuiRequestGetDataMapping(value = "/data/workflow/delete/{workflowid}")
  public GuiWorkflow deleteWorkflows(@PathVariable(name = "workflowid") final long workflowid) {
    
    return workflowHandler.getById(workflowid);
  }
  
  @FbGuiRequestGetDataMapping(value = "/data/task/list/{workflowid}")
  public List<GuiTask> listWorkflowTasks(@PathVariable(name = "workflowid") final long workflowid) {
    
    return taskHandler.listTasksByWorkflow(workflowid);
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
