package com.futurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.futurebim.core.dao.CompanyDao;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.CompanyRich;

@Service
public class CompanyReadHandler {

  @Autowired(required = true)
  @Qualifier("CompanyDaoImpl")
  private CompanyDao companyDao;

  /*
   * @Autowired(required = true) public void setCompanyService(final CompanyDao companyDao) { this.companyDao = companyDao; }
   */

  public Company addCompany(final Company c) {
    return companyDao.addCompany(c);
  }

  public boolean updateCompany(final Company c) {
    return companyDao.updateCompany(c);
  }

  public boolean removeCompany(final Long id) {
    return companyDao.removeCompany(id);
  }

  public Company getById(final Long id) {
    return companyDao.getById(id);
  }

  public CompanyRich getRichById(final Long id) {
    return companyDao.getRichById(id);
  }

  public List<Company> listCountries() {
    return companyDao.listCountries();
  }

}
