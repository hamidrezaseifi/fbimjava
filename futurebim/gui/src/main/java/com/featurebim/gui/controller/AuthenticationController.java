package com.featurebim.gui.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.authentication.UiAuthenticationErrorUrlCreator;
import com.featurebim.gui.configuration.WebSecurityConfig;
import com.featurebim.gui.helper.MessagesHelper;

/**
 * controller class to manage rest api for static page lihe home ans about and ...
 *
 * @author rezasei
 *
 */
@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {
  
  @Autowired
  private MessagesHelper messages;
  
  @GetMapping("/login")
  public String showLogin(final Model model, final HttpServletRequest request) throws ServletException, UnsupportedEncodingException {
    
    String message = "";
    String username = "";
    String company = "";
    final String password = "";
    
    if (request.getParameter("error") != null) {
      
      final Map<String, String> params = UiAuthenticationErrorUrlCreator.decodeErrorUrl(request.getParameter("error"));
      
      if (params.get("err").equals("auth")) {
        message = messages.get("common.invalidlogin");
      }
      if (params.get("err").equals("access")) {
        message = messages.get("common.noaccesssite");
      }
      
      username = params.get("u");
      company = params.get("c");
      // no password in error url // password = params.get("u");
      
    }
    
    model.addAttribute("username", username);
    model.addAttribute("password", password);
    model.addAttribute("companyid", company);
    
    model.addAttribute("logginMessage", message);
    model.addAttribute("rooturl", WebSecurityConfig.ROOT_URL);
    
    return "auth/login";
  }
  
}
