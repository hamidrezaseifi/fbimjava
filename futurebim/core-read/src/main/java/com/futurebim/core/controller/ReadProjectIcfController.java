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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.futurebim.core.bl.ProjectIcfReadHandler;
import com.futurebim.core.dao.IfcPropertyDao;
import com.futurebim.core.dao.IfcPropertySingleValueDao;
import com.futurebim.core.model.ifc.IfcProperty;
import com.futurebim.core.model.ifc.IfcPropertySingleValue;
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

  @Autowired(required = true)
  public void setPersonService(final ProjectIcfReadHandler projectIcfReadHandler) {
    this.projectIcfReadHandler = projectIcfReadHandler;
  }

  @RequestMapping(value = "/all/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse readAll(@PathVariable final Long projectId) {

    return FutureBimUiRestResponse.createDataResponse(projectIcfReadHandler.listProjectIfcs(projectId));
  }

  @RequestMapping(value = "/get/{companyid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody FutureBimUiRestResponse getCompany(@PathVariable final Long ifcid) {

    return FutureBimUiRestResponse.createDataResponse(projectIcfReadHandler.getById(ifcid));
  }

  @RequestMapping(value = "/readprop", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<String> test() throws IOException {

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
      if (ifcPropertyDao.addIfcProperty(prop) != null) {

        for (final IfcPropertySingleValue val : prop.getIfcPropertiesValues()) {

          val.setPropertyId(prop.getId());
          logger.error("nominal: " + val.getNominalValue().length() + " , " + prop.getId());

          if (val.getNominalValue().length() > 49) {

          }

          if (ifcPropertySingleValueDao.addIfcPropertySingleValue(val) != null) {

            idlist.add(prop.getId());
          }
        }

        idlist.add(prop.getId());
      }
    }

    return idlist;

  }

}
