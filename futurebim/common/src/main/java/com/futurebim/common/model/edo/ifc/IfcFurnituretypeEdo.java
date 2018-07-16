package com.futurebim.common.model.edo.ifc;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The persistent class for the ifc_furnituretypes database table.
 *
 */
public class IfcFurnituretypeEdo {

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

}
