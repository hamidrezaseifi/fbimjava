package com.seifi.test.testbim.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class MainController {
  @RequestMapping(path = "/")
  public @ResponseBody String index(final Model model){
    
    return "test index";
  }

}
