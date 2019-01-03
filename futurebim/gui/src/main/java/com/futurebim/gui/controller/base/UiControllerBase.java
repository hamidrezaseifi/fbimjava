package com.futurebim.gui.controller.base;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.futurebim.gui.configuration.WebSecurityConfig;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.enums.EGuiCompanyStatus;
import com.futurebim.gui.model.enums.EGuiUserStatus;
import com.futurebim.gui.model.futurebim.GuiCompany;
import com.futurebim.gui.model.futurebim.GuiProjectRole;
import com.futurebim.gui.model.futurebim.GuiUserFull;
import com.futurebim.gui.model.ui.GuiMenuItem;
import com.futurebim.gui.model.ui.UiSessionUserInfo;

@Controller
public abstract class UiControllerBase {
  
  protected abstract List<GuiMenuItem> getTopToolbar();
  
  protected abstract List<GuiMenuItem> getLeftToolbar();
  
  protected abstract String getActiveLeftToolbarId();

  @Autowired
  private UiSessionUserInfo sessionUserInfo;
  
  @Autowired
  protected MessagesHelper messagesHelper;

  protected String getCurrentRelatedUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String                root    = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");
    
    return path;
  }
  
  @ModelAttribute
  public void addAttributes(final Model model, final HttpSession session, final HttpServletResponse response, final HttpServletRequest request) throws IOException {
    
    // sessionUserInfo = sessionUserService.getUserFromSession(session);
    
    /*
     * redirect to login if session expired c
     */
    
    if (sessionUserInfo == null || !sessionUserInfo.isValid()) {
      response.sendRedirect(WebSecurityConfig.LOGIN_URL);
      
    }
    else {
      if (sessionUserInfo.getUser().getStatusEnum() == EGuiUserStatus.NOT_INITIALIZED) {
        response.sendRedirect(WebSecurityConfig.INITUSER_URL);

      }
      else {
        if (sessionUserInfo.getCompany().getStatusEnum() == EGuiCompanyStatus.NOT_INITIALIZED) {
          response.sendRedirect(WebSecurityConfig.INITCOMPANY_URL);

        }
      }
      
    }

    model.addAttribute("pageTopToolList", getTopToolbar());
    model.addAttribute("pageLeftToolList", getLeftToolbar());
    model.addAttribute("isLogged", getSessionUserInfo() != null);
    model.addAttribute("loggedUser", getSessionUserInfo());
    model.addAttribute("rooturl", WebSecurityConfig.ROOT_URL);
    
    model.addAttribute("url", getCurrentRelatedUrl());
    
  }
  
  public UiSessionUserInfo getSessionUserInfo() {
    return sessionUserInfo;
  }
  
  protected String getCurrentUsername() {
    return this.getSessionUserInfo().getUser().getUsername();
  }
  
  protected GuiUserFull getCurrentUser() {
    return this.getSessionUserInfo().getUser();
  }
  
  protected GuiCompany getCurrentCompany() {
    return this.getSessionUserInfo().getCompany();
  }
  
  protected List<GuiProjectRole> getProjectRoles() {
    return this.getSessionUserInfo().getProjectRoles();
  }
}
