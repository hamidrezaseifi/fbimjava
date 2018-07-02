package com.futurebim.core.model.ifc.render;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcFurnituretype;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class IfcFurnituretypeRender {

  private static final long serialVersionUID = 1L;

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

  public IfcFurnituretype toModel(final String modelId) {

    final IfcFurnituretype type = new IfcFurnituretype();
    type.setAssemblyPlace(assemblyPlace);
    type.setElementType(elementType);
    type.setId(id);
    type.setProjectIfcId(modelId);
    type.setTypeName(typeName);
    type.setTag(tag);

    return type;
  }
}
