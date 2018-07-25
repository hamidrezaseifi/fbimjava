package com.futurebim.core.dao.ifc;

import java.util.List;

import com.futurebim.core.model.ifc.ProjectIfc;

public interface ProjectIfcDao {

  public ProjectIfc addProjectIfc(ProjectIfc c);

  public boolean updateProjectIfc(ProjectIfc c);

  public boolean removeProjectIfc(Long id);

  public ProjectIfc getById(Long id);

  public List<ProjectIfc> listProjectIfcs(Long projectId);

}
