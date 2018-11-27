package com.featurebim.gui.authentication;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.featurebim.gui.configuration.WebSecurityConfig;

@Component
public class UiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private UiSessionUserService sessionUserService;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
                                                                                                                                       throws IOException,
                                                                                                                                       ServletException {

    if (auth instanceof AnonymousAuthenticationToken == false) {

      final String username = getUsernameFromAuthentication(auth);
      String url = "/";

      // if (sessionUserService.authorizeUser(username, request.getSession(), true) == null) {

      url = UiAuthenticationErrorUrlCreator.getErrorUrl("access",
                                                        request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME),
                                                        request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME));
      // }

      getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

  private String getUsernameFromAuthentication(final Authentication auth) {
    String userName = "";

    if (auth.getPrincipal() instanceof Principal) {
      final Principal principal = (Principal) auth.getPrincipal();
      userName = principal.getName();
    }
    if (auth.getPrincipal() instanceof String) {
      userName = auth.getPrincipal().toString();
    }

    return userName;
  }

}
