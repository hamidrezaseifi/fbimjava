package com.futurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.core.model.CompanyRich;
import com.futurebim.core.model.ui.FutureBimUiRestResponse;
import com.futurebim.core.dao.CompanyDao;

@RestController
@RequestMapping(path = "/company/write")
public class WriteCompany {
  
  private CompanyDao companyDao;
  
  @Autowired(required=true)
  public void setPersonService(CompanyDao companyDao){
    this.companyDao = companyDao;
  }

  @RequestMapping(value = "/delete/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse deleteCompany(@PathVariable Long companyid){
    
    return FutureBimUiRestResponse.createDataResponse(companyDao.removeCompany(companyid));
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
		  , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse updateCompany(@RequestBody(required = true) final CompanyRich company){
    
    return FutureBimUiRestResponse.createDataResponse(companyDao.updateCompany(company));
  }
  
  
}
