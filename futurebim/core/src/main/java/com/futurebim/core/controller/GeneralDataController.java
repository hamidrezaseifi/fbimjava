package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.reponse.ValueListRestResponse;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.dao.CompanyStatusDao;
import com.futurebim.core.dao.exceptions.StorageException;

@RestController
@RequestMapping(path = FbRestPaths.Core.GENERALDATA_BASE)
public class GeneralDataController {
  
  private CompanyStatusDao companyStatusDao;
  
  @Autowired(required = true)
  public void setPersonService(final CompanyStatusDao companyStatusDao) {
    this.companyStatusDao = companyStatusDao;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.GENERALDATA_VALUELIST_BASE)
  public ValueListRestResponse getValueList() throws StorageException {
    
    final ValueListRestResponse resp = ValueListRestResponse.createData();
    resp.setCompanyStatusList(companyStatusDao.listStatus().toEdo());
    
    return resp;
  }
  
}
