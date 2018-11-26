package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;

public interface CompanyDao {

  public Company addCompany(Company c) throws StorageException;

  public Company updateCompany(Company c) throws StorageException;

  public boolean removeCompany(Long id) throws StorageException;

  public Company getById(Long id) throws StorageException;

  public List<Company> listCompanies() throws StorageException;

}
