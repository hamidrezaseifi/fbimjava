package com.featurebim.gui.bl;

import java.util.List;

import com.featurebim.gui.model.futurebim.GuiProject;

public interface IProjectsHandler {
  
  public GuiProject getById(final Long id);
  
  public List<GuiProject> listProjects(final Long companyId);
  
  public GuiProject save(final GuiProject project);
  
}
