package com.futurebim.core.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.futurebim.core.model.Company;
import com.futurebim.core.dao.CompanyDao;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao {

	private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);
	
	@Autowired
  private SessionFactory sessionFactory;
	
	
	@Override
	public Company addCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		Long id = (Long)session.save(c);
		logger.info("Company saved successfully, Company Details=" + c);
		return getById(id);
	}

	@Override
	public boolean updateCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		Company uc = (Company)session.merge(c);
		logger.info("Company updated successfully, Company Details=" + c);
		return uc != null;
	}

	@Override
	public boolean removeCompany(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Company c = (Company) session.get(Company.class, id);
		
		if(null != c){
			session.delete(c);
			logger.info("Company deleted successfully, Company details="+c);
		}
		else{
			logger.info("Company not found!");
			return false;
		}
		
		return session.get(Company.class, id) == null;
	}

	@Override
	public Company getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Company c = (Company) session.get(Company.class, id);
		if(c != null){
			logger.info("Company loaded successfully, Company details="+c);
		}
		else{
			logger.info("Company not found!");
		}
		
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listCountries() {
		logger.info("Read Company List");
		Session session = this.sessionFactory.getCurrentSession();
		List<Company> personsList = session.createQuery("from Company").list();
		
		return personsList;
	}

}
