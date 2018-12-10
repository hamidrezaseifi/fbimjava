package com.featurebim.gui.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.featurebim.gui.configuration.WebSecurityConfig;

@Component
public class UiAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
  
  @Override
  public void onAuthenticationFailure(final HttpServletRequest request,
      final HttpServletResponse response,
      final AuthenticationException ex) throws IOException,
      ServletException {
    final String url = UiAuthenticationErrorUrlCreator.getErrorUrl("auth",
        request.getParameter(WebSecurityConfig.USERNAME_FIELD_NAME),
        request.getParameter(WebSecurityConfig.PASSWORD_FIELD_NAME),
        request.getParameter(WebSecurityConfig.COMPANYID_FIELD_NAME));
    
    getRedirectStrategy().sendRedirect(request, response, url);
  }
  
}
