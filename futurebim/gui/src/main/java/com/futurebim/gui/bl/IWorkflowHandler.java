package com.futurebim.gui.bl;

import java.util.List;

import com.futurebim.gui.model.futurebim.GuiWorkflow;
import com.futurebim.gui.model.futurebim.GuiWorkflowType;
import com.futurebim.gui.model.ui.GuiWorkflowCheck;
import com.futurebim.gui.model.ui.GuiWorkflowCheckResult;

public interface IWorkflowHandler {

  public GuiWorkflow getById(final Long id);

  public List<GuiWorkflow> list(final Long projectId);

  public GuiWorkflow save(final GuiWorkflow workflow);

  public boolean delete(final GuiWorkflow workflow);
  
  public String getWorkflowStatusName(final int status);

  public String getWorkflowTypeName(final int type);

  public List<GuiWorkflowType> listTypes();

  public GuiWorkflowCheckResult checkWorkflowVersion(final GuiWorkflowCheck checkingWorkflow);

}
