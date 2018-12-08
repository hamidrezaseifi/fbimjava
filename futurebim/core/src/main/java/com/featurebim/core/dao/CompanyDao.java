package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;
import com.featurebim.core.model.CompanyEmail;
import com.featurebim.core.model.CompanyPhoneNumber;
import com.featurebim.core.model.CompanyPostalAddress;

public interface CompanyDao {

  public Company addCompany(Company c) throws StorageException;

  public Company updateCompany(Company c) throws StorageException;

  public boolean removeCompany(Long id) throws StorageException;

  public Company getById(Long id) throws StorageException;

  public List<Company> listCompanies() throws StorageException;

  public List<CompanyPostalAddress> listCompanyPostalAddresses(Long companyId) throws StorageException;

  public List<CompanyPhoneNumber> listCompanyPhoneNumbers(Long companyId) throws StorageException;

  public List<CompanyEmail> listCompanyEmails(Long companyId) throws StorageException;

}
