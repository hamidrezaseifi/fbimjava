package com.featurebim.gui.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.featurebim.gui.configuration.WebSecurityConfig;
import com.featurebim.gui.model.enums.EGuiUserStatus;

@Component
public class UiAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private UiSessionUserService sessionUserService;

  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication auth)
                                                                                                                                       throws IOException,
                                                                                                                                       ServletException {

    if (auth instanceof FBAuthenticationToken == true) {

      final FBAuthenticationToken tbToken = (FBAuthenticationToken) auth;

      String url = tbToken.getUser().getStatus() == EGuiUserStatus.NOT_INITIALIZED ? WebSecurityConfig.INITUSER_URL
                                                                                   : WebSecurityConfig.ROOT_URL;

      if (tbToken.getUser().getStatus() == EGuiUserStatus.DEACTIVE || tbToken.getUser().getStatus() == EGuiUserStatus.ACTIVE
          || tbToken.getUser().getStatus() == EGuiUserStatus.UNKNOWN) {
        url = UiAuthenticationErrorUrlCreator.getErrorUrl("access",
                                                          request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME),
                                                          request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME));
      }
      else {

        if (sessionUserService.authorizeUser(tbToken, request.getSession(), true) == null) {

          url = UiAuthenticationErrorUrlCreator.getErrorUrl("access",
                                                            request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME),
                                                            request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME));
        }

      }

      getRedirectStrategy().sendRedirect(request, response, url);
    }

  }

}
