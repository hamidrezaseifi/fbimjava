package com.futurebim.common.model.edo.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IfcStairEdo {

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

  @JacksonXmlProperty(localName = "ShapeType", isAttribute = true)
  private String shapeType;

  @JacksonXmlProperty(localName = "IfcStairFlight")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairFlightEdo> stairFlightList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcMember")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairMemberEdo> memberList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcRailing")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcStairRailingEdo> railingList = new ArrayList<>();

  // @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPropertySetEdo> propertySetList = new ArrayList<>();

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(useWrapping = false)
  private final List<IfcPresentationLayerAssignmentSetEdo> presentationLayerAssignmentList = new ArrayList<>();

}
