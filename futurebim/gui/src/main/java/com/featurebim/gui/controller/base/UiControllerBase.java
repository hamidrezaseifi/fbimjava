package com.featurebim.gui.controller.base;

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

import com.featurebim.gui.authentication.UiSessionUserService;
import com.featurebim.gui.configuration.WebSecurityConfig;
import com.featurebim.gui.model.enums.EGuiUserStatus;
import com.featurebim.gui.model.futurebim.GuiUserFull;
import com.featurebim.gui.model.ui.MenuItem;
import com.featurebim.gui.model.ui.UiSessionUserInfo;

@Controller
public abstract class UiControllerBase {

  protected abstract List<MenuItem> getTopToolbar();

  protected abstract List<MenuItem> getLeftToolbar();

  protected abstract String getActiveLeftToolbarId();

  @Autowired
  private UiSessionUserService sessionUserService;

  private UiSessionUserInfo sessionUserInfo;

  protected String getCurrentRelatedUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @ModelAttribute
  public void addAttributes(final Model model,
                            final HttpSession session,
                            final HttpServletResponse response,
                            final HttpServletRequest request) throws IOException {

    sessionUserInfo = sessionUserService.getUserFromSession(session);

    /*
     * redirect to login if session expired c
     */

    if (sessionUserInfo == null) {
      response.sendRedirect(WebSecurityConfig.LOGIN_URL);
    }

    if (sessionUserInfo.getUser().getStatus() == EGuiUserStatus.NOT_INITIALIZED) {
      response.sendRedirect(WebSecurityConfig.INITUSER_URL);
    }

    model.addAttribute("pageTopToolList", getTopToolbar());
    model.addAttribute("pageLeftToolList", getLeftToolbar());
    model.addAttribute("isLogged", getSessionUserInfo() != null);
    model.addAttribute("loggedUser", getSessionUserInfo());

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
}
