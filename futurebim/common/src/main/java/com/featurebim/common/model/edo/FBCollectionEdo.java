package com.featurebim.common.model.edo;

import java.util.List;

public class FBCollectionEdo<T> {

	List<T> items;

	public FBCollectionEdo() {

	}

	public FBCollectionEdo(final List<T> items) {
		setProjects(items);
	}

	/**
	 * @return the projects
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(final List<T> items) {
		this.items = items;
	}

}
