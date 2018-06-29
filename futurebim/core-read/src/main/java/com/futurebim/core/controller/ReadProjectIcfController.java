package com.futurebim.core.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.futurebim.core.bl.ProjectIcfReadHandler;
import com.futurebim.core.dao.ifc.IfcPropertyDao;
import com.futurebim.core.dao.ifc.IfcPropertySingleValueDao;
import com.futurebim.core.model.ifc.IfcFurnituretype;
import com.futurebim.core.model.ifc.IfcProperty;
import com.futurebim.core.model.ifc.IfcPropertySingleValue;
import com.futurebim.core.model.ifc.render.ProjectIfcRender;
import com.futurebim.core.model.ui.FutureBimUiRestResponse;

@RestController
@RequestMapping(path = "/pifc/read")
public class ReadProjectIcfController {

  private final Logger logger = LoggerFactory.getLogger(ReadProjectIcfController.class);

  private ProjectIcfReadHandler projectIcfReadHandler;

  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private IfcPropertyDao ifcPropertyDao;

  @Autowired
  private IfcPropertySingleValueDao ifcPropertySingleValueDao;

  @Autowired
  private ObjectMapper                           objectMapper;
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @Autowired(required = true)
  public void setPersonService(final ProjectIcfReadHandler projectIcfReadHandler) {
    this.projectIcfReadHandler = projectIcfReadHandler;
  }

  @RequestMapping(value = "/all/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse readAll(@PathVariable final Long projectId) {

    return FutureBimUiRestResponse.createDataResponse(projectIcfReadHandler.listProjectIfcs(projectId));
  }

  @RequestMapping(value = "/get/{ifcId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse getIfc(@PathVariable final String ifcId) {

    return FutureBimUiRestResponse.createDataResponse(projectIcfReadHandler.getById(ifcId));
  }

  @RequestMapping(value = "/getrender/{ifcId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
  public @ResponseBody ProjectIfcRender getIfcRender(@PathVariable final String ifcId) {

    final XmlMapper xmlMapper = (XmlMapper) xmlConverter.getObjectMapper();
    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    xmlMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);

    return new ProjectIfcRender(projectIcfReadHandler.getById(ifcId));
  }

  @RequestMapping(value = "/readprop", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<String> readProperties() throws IOException {

    List<IfcProperty> proplist = null;
    final XmlMapper mapper = new XmlMapper();
    final Resource resource = resourceLoader.getResource("classpath:mdata/inm.xml");
    try (final InputStream is = resource.getInputStream()) {

      proplist = mapper.readValue(is, new TypeReference<List<IfcProperty>>() {
      });

    }

    final List<String> idlist = new ArrayList<>();

    for (final IfcProperty prop : proplist) {
      prop.setIfcId("Duplex_A_20110907_optimized");
      for (final IfcPropertySingleValue val : prop.getIfcPropertiesValues()) {

        val.setPropertyId(prop.getId());
      }

      if (ifcPropertyDao.addIfcProperty(prop) != null) {

        /*
         * for (final IfcPropertySingleValue val : prop.getIfcPropertiesValues()) { val.setPropertyId(prop.getId());
         * logger.error("nominal: " + val.getNominalValue().length() + " , " + prop.getId()); if (val.getNominalValue().length() > 49) { }
         * if (ifcPropertySingleValueDao.addIfcPropertySingleValue(val) != null) { idlist.add(prop.getId()); } }
         */

        idlist.add(prop.getId());
      }
    }

    return idlist;

  }

  @RequestMapping(value = "/readtypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<IfcFurnituretype> readTypes() throws IOException {

    List<IfcFurnituretype> list = null;
    final XmlMapper mapper = new XmlMapper();
    final Resource resource = resourceLoader.getResource("classpath:mdata/types.xml");
    try (final InputStream is = resource.getInputStream()) {

      list = mapper.readValue(is, new TypeReference<List<IfcFurnituretype>>() {
      });

    }

    /*
     * final List<String> idlist = new ArrayList<>(); for (final IfcProperty prop : proplist) {
     * prop.setIfcId("Duplex_A_20110907_optimized"); if (ifcPropertyDao.addIfcProperty(prop) != null) { for (final IfcPropertySingleValue
     * val : prop.getIfcPropertiesValues()) { val.setPropertyId(prop.getId()); logger.error("nominal: " + val.getNominalValue().length() +
     * " , " + prop.getId()); if (val.getNominalValue().length() > 49) { } if (ifcPropertySingleValueDao.addIfcPropertySingleValue(val) !=
     * null) { idlist.add(prop.getId()); } } idlist.add(prop.getId()); } }
     */

    return list;

  }

  @RequestMapping(value = "/readifc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody ProjectIfcRender readIfc() throws IOException {

    final ProjectIfcRender ifc;
    final XmlMapper mapper = new XmlMapper();
    final Resource resource = resourceLoader.getResource("classpath:mdata/Duplex_A_20110907_optimized.xml");
    try (final InputStream is = resource.getInputStream()) {

      ifc = mapper.readValue(is, ProjectIfcRender.class);

    }

    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    return ifc;

  }

}
