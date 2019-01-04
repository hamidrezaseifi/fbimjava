package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;

@Controller
@RequestMapping(path = "/bim")
public class BimController extends UiControllerBase {
  
  @RequestMapping(value = { "", "/", "/index" })
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Index Page");

    return "index";
  }

  @RequestMapping(path = "/balance")
  public String balance(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Balance Page");

    return "index";
  }

  @RequestMapping(path = "/alarm")
  public String alarm(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/settings")
  public String settings(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Konfiguration Page");

    return "index";
  }

  @RequestMapping(path = "/code")
  public String code(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/questions")
  public String questions(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/moves")
  public String moves(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Bim Bewegungen Page");

    return "index";
  }
  
}
