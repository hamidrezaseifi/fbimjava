package com.futurebim.core.dao;
import java.util.List;

import com.futurebim.core.model.Company;

public interface CompanyDao {

	public Company addCompany(Company c);
	public boolean updateCompany(Company c);
	public boolean removeCompany(Long id);
	public Company getById(Long id);
	public List<Company> listCountries();
	
}
