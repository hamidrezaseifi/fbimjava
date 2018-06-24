package com.futurebim.core.hp;
import java.util.List;

public interface CompanyDao {

	public void addCompany(Company c);
	public void updateCompany(Company c);
	public void removeCompany(int id);
	public Company getById(int id);
	public List<Company> listCountries();
	
}
