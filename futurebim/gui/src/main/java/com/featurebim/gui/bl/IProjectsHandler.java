package com.featurebim.gui.bl;

import java.util.List;

import com.featurebim.gui.model.futurebim.GuiProject;
import com.featurebim.gui.model.futurebim.GuiProjectRole;
import com.featurebim.gui.model.futurebim.GuiProjectUser;

public interface IProjectsHandler {
  
  public GuiProject getById(final Long id);
  
  public List<GuiProject> listProjects(final Long companyId);
  
  public GuiProject save(final GuiProject project);
  
  public boolean delete(final GuiProject project);
  
  public List<GuiProjectRole> listProjectRoles(final Long companyId);
  
  public GuiProjectRole saveProjectRole(final GuiProjectRole role);
  
  public List<GuiProjectUser> listProjectUsers(final Long projectId);
  
  public GuiProjectUser saveProjectUser(final GuiProjectUser projectUser);
  
  public boolean deleteProjectUser(final GuiProjectUser projectUser);
  
  public String getProjectAccessTypeName(final int accessType);
  
}
