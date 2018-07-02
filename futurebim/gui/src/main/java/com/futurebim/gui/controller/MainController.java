package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainController {

  @RequestMapping(path = "/")

  public String index(final Model model){
    model.addAttribute("breadCrumb" , new ArrayList());

    return "index";
  }
}
