package com.featurebim.gui.configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CompanyAuthenticationToken extends UsernamePasswordAuthenticationToken {

  private final String companyid;
  
  public CompanyAuthenticationToken(final Object principal, final Object credentials, final String companyid) {
    super(principal, credentials);
    this.companyid = companyid;
  }
  
  /**
   * @return the companyid
   */
  public String getCompanyid() {
    return companyid;
  }
  
}
