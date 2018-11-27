package com.featurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

import com.featurebim.common.model.edo.CompanyStatusListEdo;

public class ValueListRestResponse extends FeatureBimUiRestResponse {

  private CompanyStatusListEdo companyStatusList = null;

  public ValueListRestResponse() {
    super();
  }

  public static ValueListRestResponse createError(final HttpStatus status, final Exception ex) {
    return (ValueListRestResponse) new FeatureBimUiRestResponse(status, ex.getClass().getName(), ex.getMessage());
  }

  public static ValueListRestResponse createData() {
    return new ValueListRestResponse();
  }

  public CompanyStatusListEdo getCompanyStatusList() {
    return companyStatusList;
  }

  public void setCompanyStatusList(final CompanyStatusListEdo companyStatusList) {
    this.companyStatusList = companyStatusList;
  }

}
