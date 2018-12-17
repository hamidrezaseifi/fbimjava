package com.featurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.featurebim.common.exceptions.EExceptionType;
import com.featurebim.common.exceptions.FBCustomizedException;
import com.featurebim.common.model.enums.EModule;
import com.featurebim.core.bl.ICompanyHandler;
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
  public Company saveCompany(final Company c) throws StorageException {
    
    if (c.isNew()) {
      c.setVersion(1);
      return companyDao.addCompany(c);
    }

    checkRecordVersion(c.getId(), c.getVersion());
    c.setVersion(c.getVersion() + 1);
    return companyDao.updateCompany(c);
  }

  @Override
  public boolean removeCompany(final Long id) throws StorageException {
    checkRecordVersion(id, companyDao.getById(id).getVersion());
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

  private boolean checkRecordVersion(final long companyId, final int version) throws StorageException {
    final Company exists = companyDao.getById(companyId);
    if (exists.getVersion() > version) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }
    
    return true;
  }
}
