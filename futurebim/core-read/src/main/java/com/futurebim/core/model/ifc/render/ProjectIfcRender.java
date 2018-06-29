package com.futurebim.core.model.ifc.render;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcConversionBasedUnit;
import com.futurebim.core.model.ifc.IfcDoorstyle;
import com.futurebim.core.model.ifc.IfcFurnituretype;
import com.futurebim.core.model.ifc.IfcPresentationlayer;
import com.futurebim.core.model.ifc.IfcProject;
import com.futurebim.core.model.ifc.IfcWindowstyle;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@JacksonXmlRootElement(localName = "ifc", namespace = "http://www.w3.org/1999/xlink")
public class ProjectIfcRender {

  @JacksonXmlProperty(localName = "header")
  @XmlElement
  private final Map<String, Object> header = new HashMap<>();

  @JacksonXmlProperty(localName = "units")
  @XmlElement
  private final IfcUnitWrapperRender units;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  @XmlElement
  private final List<IfcPropertyRender> properties;

  private String id;

  private Timestamp created;

  private String ifcName;

  private Long projectId;

  private short status;

  private Timestamp updated;

  private final int version = 1;

  // bi-directional many-to-one association to IfcDoorstyle
  private List<IfcDoorstyle> ifcDoorstyles;

  // bi-directional many-to-one association to IfcFurnituretype
  private List<IfcFurnituretype> ifcFurnituretypes;

  // bi-directional many-to-one association to IfcPresentationlayer
  private List<IfcPresentationlayer> ifcPresentationlayers;

  // bi-directional many-to-one association to IfcProject
  private List<IfcProject> ifcProjects;

  // bi-directional many-to-one association to IfcWindowstyle
  private List<IfcWindowstyle> ifcWindowstyles;

  private List<IfcConversionBasedUnit> ifcConversionBasedUnit;

  public ProjectIfcRender(final ProjectIfc model) {
    createHeader(model);

    units = new IfcUnitWrapperRender(model);

    properties = new ArrayList<>();
    properties.addAll(IfcPropertyRender.fromModelList(model.getIfcProperties()));
  }

  private void createHeader(final ProjectIfc model) {
    // com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION
    Map<String, Object> map = new HashMap<>();
    map.put("description", "ViewDefinition [CoordinationView]");
    map.put("implementation_level", "2;1");

    header.put("file_description", map);

    map = new HashMap<>();
    map.put("author", "Future Bim");
    map.put("organization", "Future Bim");
    map.put("name", model.getIfcName());
    map.put("time_stamp", LocalDateTime.now());
    map.put("preprocessor_version", "Autodesk Revit Architecture 2011 - 1.0");
    map.put("originating_system", "");
    map.put("authorization", "Future Bim Auth!");

    header.put("file_name", map);

    map = new HashMap<>();
    map.put("schema_identifiers", "IFC2X3");

    header.put("file_schema", map);
  }

  public Map<String, Object> getHeader() {
    return header;
  }

  public IfcUnitWrapperRender getUnits() {
    return units;
  }

  public List<IfcPropertyRender> getProperties() {
    return properties;
  }

}
