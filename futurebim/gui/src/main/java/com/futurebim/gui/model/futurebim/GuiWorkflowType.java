package com.futurebim.gui.model.futurebim;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.WorkflowTypeEdo;

/**
 * The persistent class for the project_access_type database table.
 *
 */
public class GuiWorkflowType {
  
  private int id;
  
  private int status;
  
  private String typeName;
  
  private String icon;
  
  /**
   * @return the id
   */
  public int getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(final int id) {
    this.id = id;
  }
  
  /**
   * @return the status
   */
  public int getStatus() {
    return status;
  }
  
  /**
   * @param status the status to set
   */
  public void setStatus(final int status) {
    this.status = status;
  }
  
  /**
   * @return the typeName
   */
  public String getTypeName() {
    return typeName;
  }
  
  /**
   * @param typeName the typeName to set
   */
  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }
  
  /**
   * @return the icon
   */
  public String getIcon() {
    return icon;
  }
  
  /**
   * @param icon the icon to set
   */
  public void setIcon(final String icon) {
    this.icon = icon;
  }
  
  public WorkflowTypeEdo toEdo() {
    final WorkflowTypeEdo edo = new WorkflowTypeEdo();
    
    edo.setId(id);
    edo.setTypeName(typeName);
    edo.setIcon(icon);
    edo.setStatus(status);

    return edo;
  }
  
  public static GuiWorkflowType fromEdo(final WorkflowTypeEdo edo) {
    final GuiWorkflowType model = new GuiWorkflowType();
    
    model.setId(edo.getId());
    model.setTypeName(edo.getTypeName());
    model.setIcon(edo.getIcon());
    model.setStatus(edo.getStatus());
    
    return model;
  }
  
  public static List<WorkflowTypeEdo> toEdoList(final List<GuiWorkflowType> list) {
    
    final List<WorkflowTypeEdo> edoList = new ArrayList<>();
    for (final GuiWorkflowType p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiWorkflowType> fromEdoList(final List<WorkflowTypeEdo> edoList) {
    
    final List<GuiWorkflowType> list = new ArrayList<>();
    for (final WorkflowTypeEdo edo : edoList) {
      list.add(GuiWorkflowType.fromEdo(edo));
    }
    return list;
  }
}
