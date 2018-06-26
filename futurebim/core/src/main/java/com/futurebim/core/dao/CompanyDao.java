package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.Company;
import com.futurebim.core.model.CompanyRich;

public interface CompanyDao {

  public Company addCompany(Company c);

  public boolean updateCompany(Company c);

  public boolean removeCompany(Long id);

  public Company getById(Long id);

  public CompanyRich getRichById(Long id);

  public List<Company> listCountries();

}
