package com.featurebim.gui.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.featurebim.gui.configuration.WebSecurityConfig;

public class FBUiAuthenticationDetails extends WebAuthenticationDetails {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private final String companyid;

  public FBUiAuthenticationDetails(final HttpServletRequest request) {
    super(request);
    companyid = request.getParameter(WebSecurityConfig.COMPANYID_FIELD_NAME);
  }

  /**
   * @return the companyid
   */
  public String getCompanyid() {
    return companyid;
  }

}
