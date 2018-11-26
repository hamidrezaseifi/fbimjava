package com.featurebim.gui.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.gui.model.GuiLoggedData;
import com.featurebim.gui.model.futurebim.GuiUser;

@Service
public class GuiLoggedDataService implements IGuiLoggedDataService {
  
  @Autowired
  private HttpSession session;
  
  @Override
  public GuiLoggedData getLoggedData(){
    
    final GuiLoggedData data = (GuiLoggedData) session.getAttribute("loggedData");
    
    if(data != null)
    {
      data.resetLoggedTime();
    }
    return data;
  }
  
  @Override
  public boolean isLoggedIn(){
    
    final GuiLoggedData data = (GuiLoggedData) session.getAttribute("loggedData");
    
    return data != null;
  }
  
  @Override
  public GuiLoggedData createLoggedData(){
    
    GuiLoggedData data = (GuiLoggedData) session.getAttribute("loggedData");
    
    if(data == null){
      
      final GuiUser user = new GuiUser();
      user.setCompanyid(1L);
      user.setId(1L);
      user.setFirstname("User");
      user.setLastname("User");
      
      data = new GuiLoggedData(user);
      session.setAttribute("loggedData", data);
      
    }
    
    return data;
  }
}
