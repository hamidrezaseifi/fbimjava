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
  
  @RequestMapping(path = "/test")
  public String test(final Model model){
    
    return "example_BIMServer";
  }
  
  @RequestMapping(path = "/test2")
  public String test2(final Model model){
    
    return "models_loadFromServer";
  }

}
