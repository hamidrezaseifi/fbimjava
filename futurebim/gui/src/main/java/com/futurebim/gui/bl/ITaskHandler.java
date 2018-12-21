package com.futurebim.gui.bl;

import java.util.List;

import com.futurebim.gui.model.futurebim.GuiTask;

public interface ITaskHandler {
  
  public GuiTask getById(final Long id);
  
  public List<GuiTask> listTasks(final Long projectId);
  
  public List<GuiTask> listTasksByWorkflow(final Long workflowId);
  
  public GuiTask save(final GuiTask task);
  
  public boolean delete(final GuiTask task);

  public String getTaskStatusName(final int accessType);

  public boolean addWorkflowTask(final Long workflowId, final Long taskId);

  public boolean deleteWorkflowTask(final Long workflowId, final Long taskId);
  
}
