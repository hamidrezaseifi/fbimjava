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
@RequestMapping(path = "/options")
public class OptionsController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;

  @RequestMapping(path = "/")
  public String index(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Index Page");

    return "index";
  }

  @RequestMapping(path = "/balance")
  public String balance(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Balance Page");

    return "index";
  }

  @RequestMapping(path = "/alarm")
  public String alarm(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/settings")
  public String settings(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Konfiguration Page");

    return "index";
  }

  @RequestMapping(path = "/code")
  public String code(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/questions")
  public String questions(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/moves")
  public String moves(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList<>());

    model.addAttribute("msg" , "Einstellung Bewegungen Page");

    return "index";
  }

  @Override
  protected List<MenuItem> getTopToolbar() {

    return pageMenuLoader.getTopMenus("menu.settings");
  }

  @Override
  protected List<MenuItem> getLeftToolbar() {

    return pageMenuLoader.getLeftMenus("/options", getActiveLeftToolbarId());
  }

  @Override
  protected String getActiveLeftToolbarId() {
    switch(getCurrentRelatedUrl())
    {
    case "/options/balance": return "menu.balance";
    case "/options/alarm": return "menu.alarm";
    case "/options/settings": return "menu.settings";
    case "/options/code": return "menu.code";
    case "/options/questions": return "menu.questions";
    case "/options/moves": return "menu.moves";
    }

    return "";
  }
}
