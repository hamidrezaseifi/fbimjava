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
@RequestMapping(path = "/")
public class MainController extends UiControllerBase {

  @Autowired
  private PageMenuLoader pageMenuLoader;

  @RequestMapping(path = "/")
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Index Page ");

    return "index";
  }

  @RequestMapping(path = "/site/balance")
  public String balance(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Balance Page");
    return "index";
  }

  @RequestMapping(path = "/site/alarm")
  public String alarm(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/site/settings")
  public String settings(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Konfiguration Page ");

    return "index";
  }

  @RequestMapping(path = "/site/code")
  public String code(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/site/questions")
  public String questions(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/site/moves")
  public String moves(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bewegungen Page");

    return "index";
  }

  @Override
  protected List<MenuItem> getTopToolbar() {

    return pageMenuLoader.getTopMenus("menu.home");
  }

  @Override
  protected List<MenuItem> getLeftToolbar() {

    return pageMenuLoader.getLeftMenus("/site", getActiveLeftToolbarId());
  }

  @Override
  protected String getActiveLeftToolbarId() {
    switch (getCurrentRelatedUrl()) {
    case "/":
    case "":
      return "";
    case "/site/balance":
      return "menu.balance";
    case "/site/alarm":
      return "menu.alarm";
    case "/site/settings":
      return "menu.settings";
    case "/site/code":
      return "menu.code";
    case "/site/questions":
      return "menu.questions";
    case "/site/moves":
      return "menu.moves";
    }

    return "";
  }
}
