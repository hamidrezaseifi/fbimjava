package com.futurebim.gui.model.futurebim.base;

import java.time.LocalDate;

/**
 * The persistent class for the users database table.
 *
 */
public abstract class DateLimitedBase {

  public abstract LocalDate getStartDate();

  public abstract LocalDate getDeadline();
  
  public long getTotalDays() {
    final LocalDate start = getStartDate();
    final LocalDate end   = getDeadline();

    if (start == null || end == null) {
      return 0;
    }

    return java.time.temporal.ChronoUnit.DAYS.between(start, end);
  }

  public long getTotalWeeks() {
    final LocalDate start = getStartDate();
    final LocalDate end   = getDeadline();

    if (start == null || end == null) {
      return 0;
    }

    return java.time.temporal.ChronoUnit.WEEKS.between(start, end);
  }

  public long getTotalMonths() {
    final LocalDate start = getStartDate();
    final LocalDate end   = getDeadline();

    if (start == null || end == null) {
      return 0;
    }

    return java.time.temporal.ChronoUnit.MONTHS.between(start, end);
  }

  public long getTotalYears() {
    final LocalDate start = getStartDate();
    final LocalDate end   = getDeadline();

    if (start == null || end == null) {
      return 0;
    }

    return java.time.temporal.ChronoUnit.YEARS.between(start, end);
  }

}
