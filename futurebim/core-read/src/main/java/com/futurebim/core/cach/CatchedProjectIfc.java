package com.futurebim.core.cach;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

public class CatchedProjectIfc {

  public static int PROJECTIFC_MAXIMUM_AGE_MINUTES = 200;

  private final ProjectIfcEdo projectIfcEdo;
  private LocalDateTime       created;

  public CatchedProjectIfc(final ProjectIfcEdo projectIfcEdo) {
    this.projectIfcEdo = projectIfcEdo;
    this.created = LocalDateTime.now();
  }

  public ProjectIfcEdo getProjectIfcEdo() {
    return projectIfcEdo;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public long ageInMinutes() {
    return LocalDateTime.now().until(created, ChronoUnit.MINUTES);
  }

  public void resetCreated() {
    this.created = LocalDateTime.now();
  }

  public boolean isValid() {
    return (ageInMinutes() <= PROJECTIFC_MAXIMUM_AGE_MINUTES);
  }

}
