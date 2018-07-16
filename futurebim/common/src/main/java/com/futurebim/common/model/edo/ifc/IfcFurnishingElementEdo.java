package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcFurnishingElementEdo {

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String name;

  @JacksonXmlProperty(localName = "ObjectType", isAttribute = true)
  private String objectType;

  @JacksonXmlProperty(localName = "ObjectPlacement", isAttribute = true)
  private String objectPlacement;

  @JacksonXmlProperty(localName = "Tag", isAttribute = true)
  private String tag;

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcOpeningElement")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcOpeningElementEdo> openingElementList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcFurnitureTypeSetEdo> furnitureTypeList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetEdo> presentationLayerAssignmentList = new ArrayList<>();

}
