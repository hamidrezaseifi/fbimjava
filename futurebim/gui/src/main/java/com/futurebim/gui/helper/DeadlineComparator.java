package com.futurebim.gui.helper;

import java.util.Comparator;

import com.futurebim.gui.model.futurebim.base.IDateLimited;

public class DeadlineComparator implements Comparator<IDateLimited> {
  
  @Override
  public int compare(final IDateLimited t1, final IDateLimited t2) {
    
    return t1.getDeadline().isAfter(t2.getDeadline()) ? 1 : t1.getDeadline().isEqual(t2.getDeadline()) ? 0 : -1;
  }
  
}
