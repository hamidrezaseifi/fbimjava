package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcFurnituretype;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class IfcFurnituretypeRender {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String typeName;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  private String tag;

  @JacksonXmlProperty(localName = "ElementType", isAttribute = true)
  private String elementType;

  @JacksonXmlProperty(localName = "AssemblyPlace", isAttribute = true)
  private String assemblyPlace;

  public IfcFurnituretype toModel(final ProjectIfc model) {

    final IfcFurnituretype type = new IfcFurnituretype();
    type.setAssemblyPlace(assemblyPlace);
    type.setElementType(elementType);
    type.setGuid(id);
    type.setProjectIfc(model);
    type.setTypeName(typeName);
    type.setTag(tag);

    return type;
  }
}
