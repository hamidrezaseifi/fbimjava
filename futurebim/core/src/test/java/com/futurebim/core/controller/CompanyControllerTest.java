package com.futurebim.core.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.TestDataProvider;
import com.futurebim.core.bl.ICompanyHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest extends TestDataProvider {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ICompanyHandler companyReadHandler;
  
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadCompany() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.get(FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.COMPANY_READ, 123456)).andExpect(status().isConflict()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
                                                                                                                                                            ";charset=UTF-8"));
    
  }

  @Test
  public void testReadAllCompany() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get(FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.COMPANY_ALL)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
                                                                                                                                                            ";charset=UTF-8"));

  }

}
