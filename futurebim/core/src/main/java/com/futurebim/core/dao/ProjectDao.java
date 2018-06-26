package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.ProjectRich;

public interface ProjectDao {

  public ProjectRich addProject(ProjectRich c);

  public boolean updateProject(ProjectRich c);

  public boolean removeProject(Long id);

  public ProjectRich getById(Long id);

  public List<ProjectRich> listProjects();

}
