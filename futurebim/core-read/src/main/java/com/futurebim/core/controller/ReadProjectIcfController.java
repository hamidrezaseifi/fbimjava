package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.core.bl.ProjectIcfReadHandler;
import com.futurebim.core.model.ui.FutureBimUiRestResponse;

@RestController
@RequestMapping(path = "/pifc/read")
public class ReadProjectIcfController {

  private ProjectIcfReadHandler projectIcfReadHandler;

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

}
