package com.futurebim.gui.helper;

import java.util.Comparator;

import com.futurebim.gui.model.futurebim.base.IDateLimited;

public class StartDateComparator implements Comparator<IDateLimited> {
  
  @Override
  public int compare(final IDateLimited t1, final IDateLimited t2) {
    
    return t1.getStartDate().isBefore(t2.getStartDate()) ? -1 : t1.getStartDate().isEqual(t2.getStartDate()) ? 0 : 1;
  }
  
}
