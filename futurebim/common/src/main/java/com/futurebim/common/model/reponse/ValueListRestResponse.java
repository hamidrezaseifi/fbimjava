package com.futurebim.common.model.reponse;

import org.springframework.http.HttpStatus;

import com.futurebim.common.model.edo.CompanyStatusListEdo;
import com.futurebim.common.model.edo.MenuItemEdo;

public class ValueListRestResponse extends FBRestResponse {

	private CompanyStatusListEdo companyStatusList = null;
	private MenuItemEdo rootMenu = null;

	public ValueListRestResponse() {
		super();
	}

	public static ValueListRestResponse createError(final HttpStatus status, final Exception ex) {
		return (ValueListRestResponse) new FBRestResponse(status, ex.getClass().getName(), ex.getMessage());
	}

	public static ValueListRestResponse createData() {
		return new ValueListRestResponse();
	}

	public CompanyStatusListEdo getCompanyStatusList() {
		return companyStatusList;
	}

	public void setCompanyStatusList(final CompanyStatusListEdo companyStatusList) {
		this.companyStatusList = companyStatusList;
	}

	/**
	 * @return the rootMenu
	 */
	public MenuItemEdo getRootMenu() {
		return rootMenu;
	}

	/**
	 * @param rootMenu the rootMenu to set
	 */
	public void setRootMenu(final MenuItemEdo rootMenu) {
		this.rootMenu = rootMenu;
	}

}
