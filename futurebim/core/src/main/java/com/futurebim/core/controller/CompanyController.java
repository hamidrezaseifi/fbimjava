package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.reponse.FutureBimUiRestResponse;
import com.futurebim.core.bl.CompanyHandler;
import com.futurebim.core.model.Company;

@RestController
@RequestMapping(path = "/company/read")
public class CompanyController {

  private CompanyHandler companyReadHandler;

  @Autowired(required = true)
  public void setPersonService(final CompanyHandler companyReadHandler) {
    this.companyReadHandler = companyReadHandler;
  }

  @RequestMapping(value = "/delete/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse deleteCompany(@PathVariable final Long companyid) {

    return null;
  }

  @RequestMapping(value = "/update",
                  method = RequestMethod.POST,
                  consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse updateCompany(@RequestBody(required = true) final Company company) {

    return null;
  }
}
