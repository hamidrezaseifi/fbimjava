package com.futurebim.core.dao.ifc;

import java.util.List;

import com.futurebim.core.model.ifc.IfcPropertySingleValue;

public interface IfcPropertySingleValueDao {

  public IfcPropertySingleValue addIfcPropertySingleValue(IfcPropertySingleValue prop);

  public boolean updateIfcPropertySingleValue(IfcPropertySingleValue prop);

  public boolean removeIfcPropertySingleValue(String id);

  public IfcPropertySingleValue getById(Long id);

  public List<IfcPropertySingleValue> listIfcPropertyValues(String ifcpropId);

}
