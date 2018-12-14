package com.featurebim.common.model.edo;

import java.util.List;

public class ProjectCollectionEdo {

	List<ProjectEdo> projects;

	public ProjectCollectionEdo() {

	}

	public ProjectCollectionEdo(final List<ProjectEdo> projects) {
		setProjects(projects);
	}

	/**
	 * @return the projects
	 */
	public List<ProjectEdo> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(final List<ProjectEdo> projects) {
		this.projects = projects;
	}

}
