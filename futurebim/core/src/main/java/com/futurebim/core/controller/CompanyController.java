package com.futurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.ICompanyHandler;
import com.futurebim.core.model.Company;

@RestController
@RequestMapping(path = FbRestPaths.Core.COMPANY_BASE)
public class CompanyController {
  
  private ICompanyHandler companyReadHandler;
  
  @Autowired(required = true)
  public void setPersonService(final ICompanyHandler companyReadHandler) {
    this.companyReadHandler = companyReadHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.COMPANY_ALL_BASE)
  public List<CompanyEdo> readAll() throws Exception {
    final List<Company> companies = companyReadHandler.listCompanies();
    return Company.toEdoList(companies);
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.COMPANY_READ_BASE)
  public CompanyEdo getCompany(@PathVariable final Long companyid) throws Exception {
    
    return companyReadHandler.getById(companyid).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.COMPANY_DELETE_BASE)
  public boolean deleteCompany(@RequestBody(required = true) final CompanyEdo companyEdo) throws Exception {
    
    return false;
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.COMPANY_UPDATE_BASE)
  public CompanyEdo updateCompany(@RequestBody(required = true) final CompanyEdo companyEdo) throws Exception {
    
    return companyReadHandler.saveCompany(Company.fromEdo(companyEdo)).toEdo();
  }
}
