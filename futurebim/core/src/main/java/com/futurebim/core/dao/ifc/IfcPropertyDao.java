package com.futurebim.core.dao.ifc;

import java.util.List;

import com.futurebim.core.model.ifc.IfcProperty;

public interface IfcPropertyDao {

  public IfcProperty addIfcProperty(IfcProperty prop);

  public boolean updateIfcProperty(IfcProperty prop);

  public boolean removeIfcProperty(String id);

  public IfcProperty getById(String id);

  public List<IfcProperty> listIfcProperties(String ifcId);

}
