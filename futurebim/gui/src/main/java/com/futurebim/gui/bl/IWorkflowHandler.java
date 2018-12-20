package com.futurebim.gui.bl;

import java.util.List;

import com.futurebim.gui.model.futurebim.GuiWorkflow;

public interface IWorkflowHandler {

  public GuiWorkflow getById(final Long id);

  public List<GuiWorkflow> list(final Long projectId);

  public GuiWorkflow save(final GuiWorkflow workflow);

  public boolean delete(final GuiWorkflow workflow);
  
  public String getWorkflowStatusName(final int status);

  public String getWorkflowTypeName(final int type);

}
