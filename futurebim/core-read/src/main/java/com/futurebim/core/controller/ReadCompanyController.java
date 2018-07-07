package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.reponse.FutureBimUiRestResponse;
import com.futurebim.core.bl.CompanyReadHandler;
import com.futurebim.core.model.helper.ModelEdoMapper;

@RestController
@RequestMapping(path = "/company/read")
public class ReadCompanyController {

  private CompanyReadHandler companyReadHandler;

  @Autowired(required = true)
  public void setPersonService(final CompanyReadHandler companyReadHandler) {
    this.companyReadHandler = companyReadHandler;
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse readAll() {

    return FutureBimUiRestResponse.createDataResponse(ModelEdoMapper.getEdoListFromCompany(companyReadHandler.listCountries()));
  }

  @RequestMapping(value = "/get/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse getCompany(@PathVariable final Long companyid) {

    return FutureBimUiRestResponse.createDataResponse(ModelEdoMapper.getEdoFromCompany(companyReadHandler.getById(companyid)));
  }

}
