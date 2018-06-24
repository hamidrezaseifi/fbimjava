package com.futurebim.core.dao;
import java.util.List;

import com.futurebim.core.model.Company;

public interface CompanyDao {

	public void addCompany(Company c);
	public void updateCompany(Company c);
	public void removeCompany(int id);
	public Company getById(int id);
	public List<Company> listCountries();
	
}
