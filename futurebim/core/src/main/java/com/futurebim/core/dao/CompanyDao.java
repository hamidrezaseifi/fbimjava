package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.CompanyEmail;
import com.futurebim.core.model.CompanyPhoneNumber;
import com.futurebim.core.model.CompanyPostalAddress;

public interface CompanyDao {
  
  public Company addCompany(Company c) throws StorageException;
  
  public Company updateCompany(Company c) throws StorageException;
  
  public boolean removeCompany(Long id) throws StorageException;
  
  public Company getById(Long id) throws StorageException;
  
  public List<Company> listCompanies() throws StorageException;
  
  public List<CompanyPostalAddress> listCompanyPostalAddresses(Long companyId) throws StorageException;
  
  public List<CompanyPhoneNumber> listCompanyPhoneNumbers(Long companyId) throws StorageException;
  
  public List<CompanyEmail> listCompanyEmails(Long companyId) throws StorageException;

  public List<Long> listCompanyContactPersons(final Long companyId) throws StorageException;
  
}
