package com.featurebim.gui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class MainController {

  private final Logger logger = LoggerFactory.getLogger(MainController.class);

  @GetMapping("/")
  public String index(final Model model) {
    //logger.debug("test");

    return "index";
  }

}
