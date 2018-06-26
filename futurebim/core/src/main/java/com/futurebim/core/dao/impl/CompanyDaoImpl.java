package com.futurebim.core.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.futurebim.core.model.CompanyRich;
import com.futurebim.core.dao.CompanyDao;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao {

	private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);
	
	@Autowired
  private SessionFactory sessionFactory;
	
	
	@Override
	public CompanyRich addCompany(CompanyRich c) {
		Session session = this.sessionFactory.getCurrentSession();
		Long id = (Long)session.save(c);
		logger.info("Company saved successfully, Company Details=" + c);
		return getById(id);
	}

	@Override
	public boolean updateCompany(CompanyRich c) {
		Session session = this.sessionFactory.getCurrentSession();
		CompanyRich uc = (CompanyRich)session.merge(c);
		logger.info("Company updated successfully, Company Details=" + c);
		return uc != null;
	}

	@Override
	public boolean removeCompany(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		CompanyRich c = (CompanyRich) session.get(CompanyRich.class, id);
		
		if(null != c){
			session.delete(c);
			logger.info("Company deleted successfully, Company details="+c);
		}
		else{
			logger.info("Company not found!");
			return false;
		}
		
		return session.get(CompanyRich.class, id) == null;
	}

	@Override
	public CompanyRich getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		CompanyRich c = (CompanyRich) session.get(CompanyRich.class, id);
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
	public List<CompanyRich> listCountries() {
		logger.info("Read Company List");
		Session session = this.sessionFactory.getCurrentSession();
		List<CompanyRich> personsList = session.createQuery("from Company").list();
		
		return personsList;
	}

}
