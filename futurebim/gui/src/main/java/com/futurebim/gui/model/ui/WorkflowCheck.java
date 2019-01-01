package com.futurebim.gui.model.ui;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.gui.helper.FbIPair;

public class WorkflowCheck {
  
  private Long                               workflowId;
  private final List<FbIPair<Long, Integer>> taskList = new ArrayList<>();
  
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
  public List<FbIPair<Long, Integer>> getTaskList() {
    return taskList;
  }
  
  /**
   * @param taskList the taskList to set
   */
  public void setTaskList(final List<FbIPair<Long, Integer>> taskList) {
    this.taskList.clear();
    if (taskList != null) {
      this.taskList.addAll(taskList);
    }
  }

}
