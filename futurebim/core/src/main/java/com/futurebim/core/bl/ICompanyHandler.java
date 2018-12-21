package com.futurebim.core.bl;

import java.util.List;

import com.futurebim.core.model.Company;

public interface ICompanyHandler {
  
  public Company saveCompany(final Company c) throws Exception;
  
  public boolean removeCompany(final Long id) throws Exception;
  
  public Company getById(final Long id) throws Exception;
  
  public List<Company> listCompanies() throws Exception;
  
}
