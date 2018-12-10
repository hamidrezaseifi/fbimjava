package com.featurebim.gui.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CompanyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  
  @Override
  public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {

    // ...

    final UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
    setDetails(request, authRequest);

    return this.getAuthenticationManager()
        .authenticate(authRequest);
  }

  private UsernamePasswordAuthenticationToken getAuthRequest(
      final HttpServletRequest request) {

    final String username = obtainUsername(request);
    final String password = obtainPassword(request);
    final String company = request.getParameter(WebSecurityConfig.COMPANYID_FIELD_NAME);
    
    return new UsernamePasswordAuthenticationToken(usernameDomain, password);
  }
  
}
