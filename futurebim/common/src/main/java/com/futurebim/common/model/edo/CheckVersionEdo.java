package com.futurebim.common.model.edo;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the companies database table.
 *
 */
public class CheckVersionEdo {

	private Long id;

	private int version;

	private List<CheckVersionEdo> checkList = new ArrayList<>();

	public CheckVersionEdo() {
	}

	/**
	 * @return the parentId
	 */
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	/**
	 * @return the checkList
	 */
	public List<CheckVersionEdo> getCheckList() {
		return checkList;
	}

	/**
	 * @param checkList the checkList to set
	 */
	public void setCheckList(final List<CheckVersionEdo> checkList) {
		this.checkList = checkList;
	}

}
