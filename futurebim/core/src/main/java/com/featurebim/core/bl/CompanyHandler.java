package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.featurebim.core.dao.CompanyDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;

@Service
public class CompanyHandler implements ICompanyHandler {

  @Autowired(required = true)
  @Qualifier("CompanyDaoImpl")
  private CompanyDao companyDao;

  /*
   * @Autowired(required = true) public void setCompanyService(final CompanyDao companyDao) { this.companyDao = companyDao; }
   */

  @Override
  public Company addCompany(final Company c) throws StorageException {
    return companyDao.addCompany(c);
  }

  @Override
  public Company updateCompany(final Company c) throws StorageException {
    return companyDao.updateCompany(c);
  }

  @Override
  public boolean removeCompany(final Long id) throws StorageException {
    return companyDao.removeCompany(id);
  }

  @Override
  public Company getById(final Long id) throws StorageException {
    return companyDao.getById(id);
  }

  @Override
  public List<Company> listCompanies() throws StorageException {
    return companyDao.listCompanies();
  }

}
