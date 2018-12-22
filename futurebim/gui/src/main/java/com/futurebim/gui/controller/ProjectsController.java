package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.common.model.enums.EProjectAccessType;
import com.futurebim.common.model.enums.ETaskStatus;
import com.futurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.futurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.futurebim.gui.bl.IProjectsHandler;
import com.futurebim.gui.bl.ITaskHandler;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IValueHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.FbIdNamePair;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.futurebim.GuiProject;
import com.futurebim.gui.model.futurebim.GuiProjectRole;
import com.futurebim.gui.model.futurebim.GuiProjectUser;
import com.futurebim.gui.model.futurebim.GuiTask;
import com.futurebim.gui.model.futurebim.GuiUserFull;
import com.futurebim.gui.model.ui.MenuItem;

@Controller
@RequestMapping(path = "/projects")
public class ProjectsController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;
  
  @Autowired
  private IProjectsHandler projectsHandler;
  
  @Autowired
  private ITaskHandler taskHandler;
  
  @Autowired
  private IUserHandler userHandler;
  
  @Autowired
  private IValueHandler valueHandler;

  @RequestMapping(value = { "", "/", "/index" })
  public String showIndex(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());
    
    // model.addAttribute("company", this.getCurrentCompany());
    // model.addAttribute("projects", projectsHandler.listProjects(this.getCurrentCompany().getId()));
    model.addAttribute("projectTypes", valueHandler.listProjectTypes());
    
    return "projects/index";
  }

  @RequestMapping(path = "/create")
  public String createProject(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("projectId", 0);
    model.addAttribute("project", GuiProject.createNew(this.getCurrentCompany().getId(), 0L, messagesHelper.get("project.newproject")));
    model.addAttribute("projectTypes", valueHandler.listProjectTypes());
    model.addAttribute("projectStatusList", valueHandler.listProjectStatusList());
    model.addAttribute("company", this.getCurrentCompany());

    return "projects/create";
  }

  @RequestMapping(path = "/view/{projectid}")
  public String viewProject(@PathVariable(name = "projectid") final long projectid, final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    final List<FbIdNamePair> accessTypes = new ArrayList<>();
    for (final EProjectAccessType aType : EProjectAccessType.values()) {
      accessTypes.add(new FbIdNamePair(aType.getDbValue(), projectsHandler.getProjectAccessTypeName(aType.getDbValue())));
    }

    final List<FbIdNamePair> taskStatusList = new ArrayList<>();
    for (final ETaskStatus status : ETaskStatus.values()) {
      taskStatusList.add(new FbIdNamePair(status.getDbValue(), taskHandler.getTaskStatusName(status.getDbValue())));
    }

    model.addAttribute("projectId", projectid);
    model.addAttribute("projectTypes", valueHandler.listProjectTypes());
    model.addAttribute("projectRoles", this.getSessionUserInfo().getProjectRoles());
    model.addAttribute("accessTypes", accessTypes);
    model.addAttribute("taskStatusList", taskStatusList);
    model.addAttribute("company", this.getCurrentCompany());

    return "projects/view";
  }

  @RequestMapping(path = "/update/{projectid}")
  public String editProject(@PathVariable(name = "projectid") final long projectid, final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("projectId", projectid);
    model.addAttribute("project", projectsHandler.getById(projectid));
    model.addAttribute("projectTypes", valueHandler.listProjectTypes());
    model.addAttribute("projectStatusList", valueHandler.listProjectStatusList());
    model.addAttribute("company", this.getCurrentCompany());

    return "projects/update";
  }

  @RequestMapping(path = "/delete/{projectid}")
  public String deleteProject(@PathVariable(name = "projectid") final long projectid, final Model model) {

    final GuiProject project = projectsHandler.getById(projectid);
    final String     msg     = messagesHelper.get("project.delete-project-message");
    
    model.addAttribute("msg", msg);
    model.addAttribute("project", project);
    model.addAttribute("projectName", project.getProjectName());
    model.addAttribute("projectId", projectid);

    return "projects/delete";
  }

  @FbGuiRequestGetDataMapping(value = "/data/projectlist")
  public Map<String, Object> getProjectListData() {
    final Map<String, Object> list = new HashMap<>();

    list.put("projects", projectsHandler.listProjects(this.getCurrentCompany().getId()));
    list.put("company", this.getCurrentCompany());

    return list;
  }

  @FbGuiRequestGetDataMapping(value = "/data/projectrolelist")
  public List<GuiProjectRole> getProjectRoleListData() {
    return this.getProjectRoles();
  }

  @FbGuiRequestGetDataMapping(value = "/data/project/read/{projectid}")
  public GuiProject getProjectData(@PathVariable(name = "projectid") final long projectid) {

    if (projectid == 0L) {
      return GuiProject.createNew(this.getCurrentCompany().getId(), 0L, messagesHelper.get("project.newproject"));
    }
    
    return projectsHandler.getById(projectid);
  }

  @FbGuiRequestGetDataMapping(value = "/data/user/add/{projectid}/{userid}")
  public GuiProjectUser addProjectUser(@PathVariable(name = "projectid") final long projectid, @PathVariable(name = "userid") final long userid) {
    
    final GuiProjectUser pUser = new GuiProjectUser();
    pUser.setProjectId(projectid);
    pUser.setUserId(userid);
    pUser.setAccessType(EProjectAccessType.READ.getDbValue());
    pUser.setRoleId(0L);
    
    return projectsHandler.saveProjectUser(pUser);
  }

  @FbGuiRequestPostDataMapping(value = "/data/user/update")
  public GuiProjectUser editProjectUser(@RequestBody final GuiProjectUser pUser) {
    
    return projectsHandler.saveProjectUser(pUser);
  }

  @FbGuiRequestGetDataMapping(value = "/data/user/delete/{projectid}/{userid}")
  public boolean deleteProjectUser(@PathVariable(name = "projectid") final long projectid, @PathVariable(name = "userid") final long userid) {
    
    final GuiProjectUser pUser = new GuiProjectUser();
    pUser.setProjectId(projectid);
    pUser.setUserId(userid);
    pUser.setAccessType(0);
    pUser.setRoleId(0L);
    
    return projectsHandler.deleteProjectUser(pUser);
  }
  
  @FbGuiRequestPostDataMapping(value = "/data/project/save")
  public GuiProject saveProjectData(@RequestBody final GuiProject project) {
    
    return projectsHandler.save(project);
  }

  @FbGuiRequestPostDataMapping(value = "/data/project/delete")
  public boolean deleteProjectData(@RequestBody final GuiProject project) {
    
    return projectsHandler.delete(project);
  }

  @FbGuiRequestGetDataMapping(value = "/data/users/all")
  public List<GuiUserFull> readUserList() {
    
    return userHandler.listCompanyUsers(this.getCurrentCompany().getId());
  }

  @FbGuiRequestGetDataMapping(value = "/data/task/all")
  public List<GuiUserFull> readTaskList() {
    
    return userHandler.listCompanyUsers(this.getCurrentCompany().getId());
  }
  
  @FbGuiRequestPostDataMapping(value = "/data/task/add")
  public GuiTask addProjectTask(@RequestBody final GuiTask task) {
    
    task.setStatus(1);
    task.setReporter(this.getCurrentUser().getId());
    
    return taskHandler.save(task);
  }

  @FbGuiRequestPostDataMapping(value = "/data/task/update")
  public GuiTask editProjectTask(@RequestBody final GuiTask task) {
    
    return taskHandler.save(task);
  }

  @FbGuiRequestPostDataMapping(value = "/data/task/delete")
  public boolean deleteProjectTask(@RequestBody final GuiTask task) {

    return taskHandler.delete(task);
  }
  
  @Override
  protected List<MenuItem> getTopToolbar() {

    return pageMenuLoader.getTopMenus("menu.projects");
  }

  @Override
  protected List<MenuItem> getLeftToolbar() {

    final List<MenuItem> menus = new ArrayList<>();

    MenuItem m = new MenuItem("menu.index", messagesHelper.get("project.projects-list"), "list", "/projects");

    m.setActive(false);
    if (getCurrentRelatedUrl().equals("/projects") || getCurrentRelatedUrl().equals("/projects/") || getCurrentRelatedUrl().equals("/projects/index")) {
      m.setActive(true);
    }
    menus.add(m);

    m = new MenuItem("menu.create", messagesHelper.get("project.projects-create"), "playlist_add", "/projects/create");

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
