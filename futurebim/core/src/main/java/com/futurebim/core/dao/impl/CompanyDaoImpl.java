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
	public void addCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Company saved successfully, Company Details=" + c);
	}

	@Override
	public void updateCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Company updated successfully, Company Details=" + c);

	}

	@Override
	public void removeCompany(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Company c = (Company) session.load(Company.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Company deleted successfully, person details="+c);

	}

	@Override
	public Company getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Company c = (Company) session.load(Company.class, new Integer(id));
		logger.info("Company loaded successfully, Company details="+c);
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Company> personsList = session.createQuery("from Company").list();
		for(Company c : personsList){
			logger.info("Company List::"+c);
		}
		return personsList;
	}

}
