package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.Project;

public interface ProjectDao {

	public Project addProject(Project c);
	public boolean updateProject(Project c);
	public boolean removeProject(Long id);
	public Project getById(Long id);
	public List<Project> listProjects();
	
}
