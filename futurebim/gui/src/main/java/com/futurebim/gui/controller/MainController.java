package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.helper.PageMenuLoader;

@Controller
@RequestMapping(path = "/")
public class MainController {

  @Autowired
  private PageMenuLoader pageMenuLoader;

  @RequestMapping(path = "/")
  public String index(final Model model){
    model.addAttribute("pageMenuList" , pageMenuLoader.getTopMenus());
    model.addAttribute("pageLeftMenuList" , pageMenuLoader.getLeftMenus());
    model.addAttribute("breadCrumb" , new ArrayList<>());

    return "index";
  }
}
