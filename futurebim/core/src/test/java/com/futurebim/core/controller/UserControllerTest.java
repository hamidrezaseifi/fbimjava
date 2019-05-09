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

import com.futurebim.common.model.edo.EncryptedContentEdo;
import com.futurebim.common.model.edo.UserFullEdo;
import com.futurebim.common.model.edo.UserLoginEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.TestDataProvider;
import com.futurebim.core.bl.IUserHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends TestDataProvider {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  // @MockBean
  // private MappingJackson2XmlHttpMessageConverter mappingJackson2HttpMessageConverter;

  @MockBean
  private IUserHandler userHandler;
  
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadCompanyUsers() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.get(FbRestPaths.Core.USER_COMPANYUSERS, 123456)).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
            ";charset=UTF-8"));
    
  }

  @Test
  public void testAuthenticateUser() throws Exception {
    
    final UserLoginEdo loginEdo = new UserLoginEdo("user1", "password1", "companyindent");
    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(loginEdo, xmlConverter.getObjectMapper());
    }
    catch (final Exception e) {
      
    }
    
    final String contentrAsString = xmlConverter.getObjectMapper().writeValueAsString(encrypedEdo);
    
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(FbRestPaths.Core.USER_AUTHENTICATE).content(contentrAsString).contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isConflict()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
            ";charset=UTF-8"));
    
  }

  @Test
  public void testSaveUser() throws Exception {
    
    final UserFullEdo edo = new UserFullEdo();
    edo.setId(99234567L);
    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(edo, xmlConverter.getObjectMapper());
    }
    catch (final Exception e) {
      
    }
    
    final String contentrAsString = xmlConverter.getObjectMapper().writeValueAsString(encrypedEdo);
    
    mockMvc.perform(MockMvcRequestBuilders.post(FbRestPaths.Core.USER_SAVE).content(contentrAsString).contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isConflict()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
            ";charset=UTF-8"));
  }

  @Test
  public void testSetUserPassword() throws Exception {
    
    final UserFullEdo edo = new UserFullEdo();
    edo.setId(99234567L);
    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(edo, xmlConverter.getObjectMapper());
    }
    catch (final Exception e) {
      
    }
    
    final String contentrAsString = xmlConverter.getObjectMapper().writeValueAsString(encrypedEdo);
    
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(FbRestPaths.Core.USER_SETPASSWORD).content(contentrAsString).contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().isConflict()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
            ";charset=UTF-8"));
  }
  
  @Test
  public void testReadUser() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.get(FbRestPaths.Core.USER_READ, 999123456)).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE +
            ";charset=UTF-8"));
    
  }
}
