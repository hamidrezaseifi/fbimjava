package com.futurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.ICompanyHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Company;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
  
  private ICompanyHandler companyReadHandler;
  
  @Autowired(required = true)
  public void setPersonService(final ICompanyHandler companyReadHandler) {
    this.companyReadHandler = companyReadHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = "/all")
  public List<CompanyEdo> readAll() throws StorageException {
    final List<Company> companies = companyReadHandler.listCompanies();
    return Company.toEdoList(companies);
  }
  
  @FbCoreRequestGetDataMapping(value = "/read/{companyid}")
  public CompanyEdo getCompany(@PathVariable final Long companyid) throws StorageException {
    
    return companyReadHandler.getById(companyid).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = "/delete")
  public boolean deleteCompany(@RequestBody(required = true) final CompanyEdo companyEdo) {
    
    return false;
  }
  
  @FbCoreRequestPostDataMapping(value = "/update")
  public CompanyEdo updateCompany(@RequestBody(required = true) final CompanyEdo companyEdo) throws StorageException {
    
    return companyReadHandler.saveCompany(Company.fromEdo(companyEdo)).toEdo();
  }
}
