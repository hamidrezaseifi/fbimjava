package com.futurebim.gui.model.ui;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.gui.helper.FbIPair;

public class GuiWorkflowCheckResult {

  private Long                               workflowId;
  private final List<FbIPair<Long, Boolean>> taskList = new ArrayList<>();

  public GuiWorkflowCheckResult() {
    
  }

  public GuiWorkflowCheckResult(final Long workflowId) {
    this.workflowId = workflowId;
  }
  
  /**
   * @return the workflowId
   */
  public Long getWorkflowId() {
    return workflowId;
  }

  /**
   * @param workflowId the workflowId to set
   */
  public void setWorkflowId(final Long workflowId) {
    this.workflowId = workflowId;
  }

  /**
   * @return the taskList
   */
  public List<FbIPair<Long, Boolean>> getTaskList() {
    return taskList;
  }

  /**
   * @param taskList the taskList to set
   */
  public void setTaskList(final List<FbIPair<Long, Boolean>> taskList) {
    this.taskList.clear();
    if (taskList != null) {
      this.taskList.addAll(taskList);
    }
  }

  /**
   * @param taskList the taskList to set
   */
  public void addTaskCheckItem(final Long id, final Boolean res) {
    this.taskList.add(new FbIPair<>(id, res));
  }
  
}
