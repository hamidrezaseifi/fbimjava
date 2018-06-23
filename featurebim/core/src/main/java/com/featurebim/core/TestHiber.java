package com.featurebim.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.core.hp.Company;
import com.featurebim.core.hp.CompanyDao;

@Service
public class TestHiber {
	
	CompanyDao companyDao;
	
	/*@Autowired(required=true)
	public void setPersonService(CompanyDao companyDao){
		this.companyDao = companyDao;
	}*/
	
	public List<Company> listCountries(){
		//return companyDao.listCountries();
	  
	  return new ArrayList<>();
	}
	
}
