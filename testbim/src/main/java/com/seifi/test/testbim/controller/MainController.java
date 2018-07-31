package com.seifi.test.testbim.controller;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class MainController {
  
  @RequestMapping(path = "/")
  public @ResponseBody String index(final Model model){
    
    BimServerConfig config = new BimServerConfig();
    config.setAutoMigrate(true);
    config.setPort(2020);
    config.setStartEmbeddedWebServer(true);
    
    BimServer serv = new BimServer(config);
    
    return "test index";
  }
  
  @RequestMapping(path = "/test")
  public @ResponseBody String test(final Model model){
    
    return "test url";
  }

}
