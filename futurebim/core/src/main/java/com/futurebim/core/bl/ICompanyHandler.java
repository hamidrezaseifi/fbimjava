package com.futurebim.core.bl;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Company;

public interface ICompanyHandler {

  public Company saveCompany(final Company c) throws StorageException;

  public boolean removeCompany(final Long id) throws StorageException;

  public Company getById(final Long id) throws StorageException;

  public List<Company> listCompanies() throws StorageException;

}
