package com.futurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futurebim.common.model.edo.SubTaskEdo;
import com.futurebim.common.rest.json.JsonConstants;

/**
 * The persistent class for the users database table.
 *
 */
public class GuiSubTask {
  
  private Long id;
  
  private Long taskid;
  
  private String title;
  
  private int progress;
  
  private String comments;
  
  private Long reporter;
  
  private int status;
  
  private int version;
  
  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime created;
  
  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime updated;
  
  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id != null ? id : 0;
  }
  
  /**
   * @return the taskid
   */
  public Long getTaskid() {
    return taskid;
  }
  
  /**
   * @param taskid the taskid to set
   */
  public void setTaskid(final Long taskid) {
    this.taskid = taskid != null ? taskid : 0;
  }
  
  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * @param title the title to set
   */
  public void setTitle(final String title) {
    this.title = title;
  }
  
  /**
   * @return the progress
   */
  public int getProgress() {
    return progress;
  }
  
  /**
   * @param progress the progress to set
   */
  public void setProgress(final int progress) {
    this.progress = progress;
  }
  
  /**
   * @return the comments
   */
  public String getComments() {
    return comments;
  }
  
  /**
   * @param comments the comments to set
   */
  public void setComments(final String comments) {
    this.comments = comments;
  }
  
  /**
   * @return the reporter
   */
  public Long getReporter() {
    return reporter;
  }
  
  /**
   * @param reporter the reporter to set
   */
  public void setReporter(final Long reporter) {
    this.reporter = reporter != null ? reporter : 0;
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
   * @return the version
   */
  public int getVersion() {
    return version;
  }
  
  /**
   * @param version the version to set
   */
  public void setVersion(final int version) {
    this.version = version;
  }
  
  /**
   * @return the created
   */
  public LocalDateTime getCreated() {
    return created;
  }
  
  /**
   * @param created the created to set
   */
  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }
  
  /**
   * @return the updated
   */
  public LocalDateTime getUpdated() {
    return updated;
  }
  
  /**
   * @param updated the updated to set
   */
  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }
  
  public SubTaskEdo toEdo() {
    final SubTaskEdo edo = new SubTaskEdo();
    edo.setTaskid(taskid);
    edo.setComments(comments);
    edo.setId(id);
    edo.setTitle(title);
    edo.setReporter(reporter);
    edo.setProgress(progress);
    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);
    
    return edo;
  }
  
  public static GuiSubTask fromEdo(final SubTaskEdo edo) {
    final GuiSubTask model = new GuiSubTask();
    
    model.setTaskid(edo.getTaskid());
    model.setComments(edo.getComments());
    model.setId(edo.getId());
    model.setTitle(edo.getTitle());
    model.setReporter(edo.getReporter());
    model.setProgress(edo.getProgress());
    
    model.setCreated(edo.getCreated());
    model.setId(edo.getId());
    model.setStatus(edo.getStatus());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());
    
    return model;
  }
  
  public static List<SubTaskEdo> toEdoList(final List<GuiSubTask> list) {
    
    final List<SubTaskEdo> edoList = new ArrayList<>();
    for (final GuiSubTask p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiSubTask> fromEdoList(final List<SubTaskEdo> edoList) {
    
    final List<GuiSubTask> list = new ArrayList<>();
    for (final SubTaskEdo edo : edoList) {
      list.add(GuiSubTask.fromEdo(edo));
    }
    return list;
  }
}
