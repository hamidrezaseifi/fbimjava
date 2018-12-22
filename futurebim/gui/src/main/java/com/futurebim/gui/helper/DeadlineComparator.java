package com.futurebim.gui.helper;

import java.util.Comparator;

import com.futurebim.gui.model.futurebim.base.DateLimitedBase;

public class DeadlineComparator implements Comparator<DateLimitedBase> {
  
  @Override
  public int compare(final DateLimitedBase t1, final DateLimitedBase t2) {
    
    return t1.getDeadline().isAfter(t2.getDeadline()) ? 1 : t1.getDeadline().isEqual(t2.getDeadline()) ? 0 : -1;
  }
  
}
