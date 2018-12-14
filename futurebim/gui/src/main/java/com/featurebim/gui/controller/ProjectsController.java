package com.featurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.bl.IProjectsHandler;
import com.featurebim.gui.controller.base.UiControllerBase;
import com.featurebim.gui.helper.PageMenuLoader;
import com.featurebim.gui.model.ui.MenuItem;

@Controller
@RequestMapping(path = "/projects")
public class ProjectsController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;
  
  @Autowired
  private IProjectsHandler projectsHandler;

  @RequestMapping(value = { "", "/", "/index" })
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());
    
    model.addAttribute("company", this.getSessionUserInfo().getCompany());
    model.addAttribute("projects", projectsHandler.listProjects(this.getSessionUserInfo().getCompany().getId()));
    
    return "projects/index";
  }

  @RequestMapping(path = "/create")
  public String createProject(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Projekte Balance Page");

    return "projects/create";
  }

  @RequestMapping(path = "/view/{projectid}")
  public String viewProject(@PathVariable(name = "projectid") final long projectid, final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Projekte Alarm Page");

    return "projects/view";
  }

  @RequestMapping(path = "/update/{projectid}")
  public String editProject(@PathVariable(name = "projectid") final long projectid, final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Projekte Alarm Page");

    return "projects/update";
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
