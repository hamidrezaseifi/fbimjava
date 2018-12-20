package com.futurebim.gui.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.futurebim.gui.configuration.WebSecurityConfig;
import com.futurebim.gui.model.enums.EGuiUserStatus;

@Component
public class UiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private UiSessionUserService sessionUserService;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth) throws IOException, ServletException {

    if (auth instanceof FBAuthenticationToken == true) {

      final FBAuthenticationToken tbToken = (FBAuthenticationToken) auth;

      String url = WebSecurityConfig.ROOT_URL;

      if (tbToken.getUser().getStatusEnum() == EGuiUserStatus.DEACTIVE || tbToken.getUser().getStatusEnum() == EGuiUserStatus.UNKNOWN) {
        url = UiAuthenticationErrorUrlCreator.getErrorUrl("access", request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME), request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME), request.getParameter(WebSecurityConfig.COMPANYID_FIELD_NAME));
      }
      else {

        if (sessionUserService.authorizeUser(tbToken, request.getSession(), true) == null) {

          url = UiAuthenticationErrorUrlCreator.getErrorUrl("access", request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME), request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME), request.getParameter(WebSecurityConfig.COMPANYID_FIELD_NAME));
        }

        if (tbToken.getDetails() instanceof FBUiAuthenticationDetails) {
          final String companyid        = ((FBUiAuthenticationDetails) tbToken.getDetails()).getCompanyid();
          final Cookie companyIndCookie = new Cookie(WebSecurityConfig.COMPANYINDICATOR_COOKIE_KEY, companyid);
          companyIndCookie.setMaxAge(10 * 365 * 24 * 60 * 60);
          response.addCookie(companyIndCookie);
        }

      }

      getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}
