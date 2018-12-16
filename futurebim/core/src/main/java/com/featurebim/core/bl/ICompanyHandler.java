package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;

public interface ICompanyHandler {

  public Company saveCompany(final Company c) throws StorageException;

  public boolean removeCompany(final Long id) throws StorageException;

  public Company getById(final Long id) throws StorageException;

  public List<Company> listCompanies() throws StorageException;

}
