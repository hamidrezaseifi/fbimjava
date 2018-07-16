package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.core.model.ifc.IfcProject;
import com.futurebim.core.model.ifc.ProjectIfc;

public class IfcDecompositionWrapperRender {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcProject")
  private final List<IfcProjectRender> projects = new ArrayList<>();

  public List<IfcProject> toModel(final ProjectIfc model) {

    final List<IfcProject> list = new ArrayList<>();

    for (final IfcProjectRender pr : projects) {
      list.add(pr.toModel(model));
    }

    return list;
  }
}
