package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;

@Controller
@RequestMapping(path = "/options")
public class OptionsController extends UiControllerBase {
  
  @RequestMapping(value = { "", "/", "/index" })
  public String index(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Index Page");

    return "index";
  }

  @RequestMapping(path = "/balance")
  public String balance(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Balance Page");

    return "index";
  }

  @RequestMapping(path = "/alarm")
  public String alarm(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Alarm Page");

    return "index";
  }

  @RequestMapping(path = "/settings")
  public String settings(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Konfiguration Page");

    return "index";
  }

  @RequestMapping(path = "/code")
  public String code(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Entwicklung Page");

    return "index";
  }

  @RequestMapping(path = "/questions")
  public String questions(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Fragen Page");

    return "index";
  }

  @RequestMapping(path = "/moves")
  public String moves(final Model model) {
    model.addAttribute("breadCrumb", new ArrayList<>());

    model.addAttribute("msg", "Einstellung Bewegungen Page");

    return "index";
  }

}
