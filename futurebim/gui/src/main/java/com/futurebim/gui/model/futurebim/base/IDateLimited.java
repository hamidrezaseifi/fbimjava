package com.futurebim.gui.model.futurebim.base;

import java.time.LocalDate;

/**
 * The persistent class for the users database table.
 *
 */
public interface IDateLimited {
  
  public LocalDate getStartDate();
  
  public LocalDate getDeadline();

}
