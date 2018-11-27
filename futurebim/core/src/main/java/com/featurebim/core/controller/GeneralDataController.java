package com.featurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.reponse.ValueListRestResponse;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.dao.CompanyStatusDao;
import com.featurebim.core.dao.exceptions.StorageException;

@RestController
@RequestMapping(path = "/general")
public class GeneralDataController {

  private CompanyStatusDao companyStatusDao;

  @Autowired(required = true)
  public void setPersonService(final CompanyStatusDao companyStatusDao) {
    this.companyStatusDao = companyStatusDao;
  }

  @FbCoreRequestGetDataMapping(value = "/valuelist")
  public ValueListRestResponse getValueList() throws StorageException {

    final ValueListRestResponse resp = ValueListRestResponse.createData();
    resp.setCompanyStatusList(companyStatusDao.listStatus().toEdo());

    return resp;
  }

}
