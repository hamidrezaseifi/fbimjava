package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.ifc.ProjectIfc;

public interface ProjectIcfDao {

  public ProjectIfc addProjectIfc(ProjectIfc c);

  public boolean updateProjectIfc(ProjectIfc c);

  public boolean removeProjectIfc(Long id);

  public ProjectIfc getById(Long id);

  public List<ProjectIfc> listProjectIfcs(Long projectId);

}
