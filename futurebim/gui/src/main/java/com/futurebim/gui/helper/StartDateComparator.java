package com.futurebim.gui.helper;

import java.util.Comparator;

import com.futurebim.gui.model.futurebim.base.DateLimitedBase;

public class StartDateComparator implements Comparator<DateLimitedBase> {
  
  @Override
  public int compare(final DateLimitedBase t1, final DateLimitedBase t2) {
    
    return t1.getStartDate().isBefore(t2.getStartDate()) ? -1 : t1.getStartDate().isEqual(t2.getStartDate()) ? 0 : 1;
  }
  
}
