package com.featurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.CompanyEdo;
import com.featurebim.common.model.reponse.FBUiRestResponse;
import com.featurebim.common.model.reponse.GeneralRestResponse;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.CompanyHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

  private CompanyHandler companyReadHandler;

  @Autowired(required = true)
  public void setPersonService(final CompanyHandler companyReadHandler) {
    this.companyReadHandler = companyReadHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/all")
  public GeneralRestResponse readAll() throws StorageException {
    final List<Company> companies = companyReadHandler.listCompanies();
    return GeneralRestResponse.createData(Company.toEdoList(companies));
  }

  @FbCoreRequestGetDataMapping(value = "/read/{companyid}")
  public GeneralRestResponse getCompany(@PathVariable final Long companyid) throws StorageException {

    return GeneralRestResponse.createData((companyReadHandler.getById(companyid).toEdo()));
  }

  @FbCoreRequestPostDataMapping(value = "/delete")
  public FBUiRestResponse deleteCompany(@RequestBody(required = true) final CompanyEdo companyEdo) {

    return null;
  }

  @FbCoreRequestPostDataMapping(value = "/update")
  public FBUiRestResponse updateCompany(@RequestBody(required = true) final CompanyEdo companyEdo) throws StorageException {

    return GeneralRestResponse.createData(companyReadHandler.updateCompany(Company.fromEdo(companyEdo)));
  }
}
