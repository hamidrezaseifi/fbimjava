package com.featurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.reponse.FeatureBimUiRestResponse;
import com.featurebim.common.model.reponse.GeneralRestResponse;
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

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody GeneralRestResponse readAll() throws StorageException {
    final List<Company> companies = companyReadHandler.listCompanies();
    return GeneralRestResponse.createData(Company.toEdoList(companies));
  }

  @RequestMapping(value = "/read/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody GeneralRestResponse getCompany(@PathVariable final Long companyid) throws StorageException {

    return GeneralRestResponse.createData((companyReadHandler.getById(companyid).toEdo()));
  }

  @RequestMapping(value = "/delete/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FeatureBimUiRestResponse deleteCompany(@PathVariable final Long companyid) {

    return null;
  }

  @RequestMapping(value = "/update",
                  method = RequestMethod.POST,
                  consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FeatureBimUiRestResponse updateCompany(@RequestBody(required = true) final Company company) {

    return null;
  }
}
