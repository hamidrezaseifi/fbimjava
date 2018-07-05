package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.MenuItem;

@Controller
@RequestMapping(path = "/workflow")
public class WorkflowController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;

  @RequestMapping(path = "/")
  public String index(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Index Page");

    return "index";
  }

  @RequestMapping(path = "/balance")
  public String balance(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Balance Page");

    return "index";
  }

  @RequestMapping(path = "/alarm")
  public String alarm(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/settings")
  public String settings(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Konfiguration Page");

    return "index";
  }

  @RequestMapping(path = "/code")
  public String code(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/questions")
  public String questions(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/moves")
  public String moves(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Workflow Bewegungen Page");

    return "index";
  }

  @Override
  protected List<MenuItem> getTopToolbar() {

    return pageMenuLoader.getTopMenus("menu.workflow");
  }

  @Override
  protected List<MenuItem> getLeftToolbar() {

    return pageMenuLoader.getLeftMenus("/workflow", getActiveLeftToolbarId());
  }

  @Override
  protected String getActiveLeftToolbarId() {
    switch(getCurrentRelatedUrl())
    {
    case "/workflow/balance": return "menu.balance";
    case "/workflow/alarm": return "menu.alarm";
    case "/workflow/settings": return "menu.settings";
    case "/workflow/code": return "menu.code";
    case "/workflow/questions": return "menu.questions";
    case "/workflow/moves": return "menu.moves";
    }

    return "";
  }
}
