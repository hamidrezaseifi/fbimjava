package com.featurebim.core.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TestListReader {

  @JacksonXmlProperty(localName = "Cell")
  @JacksonXmlElementWrapper(useWrapping = false)
  List<String> Cell = new ArrayList<>();

  public List<String> getCell() {
    return Cell;
  }

  public void setCell(final List<String> cell) {
    Cell = cell;
  }

}
