package com.futurebim.common.model.edo.ifc;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@JacksonXmlRootElement(localName = "ifc", namespace = "http://www.w3.org/1999/xlink")
public class ProjectIfcEdo {

  @JacksonXmlProperty(localName = "header")
  private final Map<String, Object> header = new HashMap<>();

  @JacksonXmlProperty(localName = "units")
  private IfcUnitWrapperEdo units;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  private List<IfcPropertyEdo> properties;

  @JacksonXmlProperty(localName = "types")
  private IfcTypeWrapperEdo types;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  private List<IfcPresentationlayerEdo> layers;

  @JacksonXmlElementWrapper(localName = "decomposition")
  private IfcDecompositionWrapperEdo decomposition;

  public ProjectIfcEdo() {

  }

  public ProjectIfcEdo(final String name) {
    createHeader(name);

  }

  private void createHeader(final String name) {
    // com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION
    Map<String, Object> map = new HashMap<>();
    map.put("description", "ViewDefinition [CoordinationView]");
    map.put("implementation_level", "2;1");

    header.put("file_description", map);

    map = new HashMap<>();
    map.put("author", "Future Bim");
    map.put("organization", "Future Bim");
    map.put("name", name);
    map.put("time_stamp", LocalDateTime.now());
    map.put("preprocessor_version", "Autodesk Revit Architecture 2011 - 1.0");
    map.put("originating_system", "");
    map.put("authorization", "Future Bim Auth!");

    header.put("file_name", map);

    map = new HashMap<>();
    map.put("schema_identifiers", "IFC2X3");

    header.put("file_schema", map);
  }

  @JsonIgnore
  public String getName() {
    if (header.keySet().contains("file_name")) {
      final Map<String, Object> file_name = (Map<String, Object>) header.get("file_name");
      if (file_name.keySet().contains("name")) {
        return file_name.get("name").toString();

      }
    }

    return "";
  }

}
