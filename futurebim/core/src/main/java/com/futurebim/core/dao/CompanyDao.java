package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.CompanyRich;

public interface CompanyDao {

  public CompanyRich addCompany(CompanyRich c);

  public boolean updateCompany(CompanyRich c);

  public boolean removeCompany(Long id);

  public CompanyRich getById(Long id);

  public List<CompanyRich> listCountries();

}
