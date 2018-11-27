package com.featurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.controller.base.UiControllerBase;
import com.featurebim.gui.helper.PageMenuLoader;
import com.featurebim.gui.model.ui.MenuItem;

@Controller
@RequestMapping(path = "/projects")
public class ProjectsController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;

  @RequestMapping(path = "/")
  public String index(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Index Page");

    return "index";
  }

  @RequestMapping(path = "/balance")
  public String balance(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Balance Page");

    return "index";
  }

  @RequestMapping(path = "/alarm")
  public String alarm(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/settings")
  public String settings(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Konfiguration Page");

    return "index";
  }

  @RequestMapping(path = "/code")
  public String code(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/questions")
  public String questions(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/moves")
  public String moves(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Projekte Bewegungen Page");

    return "index";
  }

  @Override
  protected List<MenuItem> getTopToolbar() {

    return pageMenuLoader.getTopMenus("menu.projects");
  }

  @Override
  protected List<MenuItem> getLeftToolbar() {

    return pageMenuLoader.getLeftMenus("/projects", getActiveLeftToolbarId());
  }

  @Override
  protected String getActiveLeftToolbarId() {
    switch(getCurrentRelatedUrl())
    {
    case "/projects/balance": return "menu.balance";
    case "/projects/alarm": return "menu.alarm";
    case "/projects/settings": return "menu.settings";
    case "/projects/code": return "menu.code";
    case "/projects/questions": return "menu.questions";
    case "/projects/moves": return "menu.moves";
    }

    return "";
  }
}
