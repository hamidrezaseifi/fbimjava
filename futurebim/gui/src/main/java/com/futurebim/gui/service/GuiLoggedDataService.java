package com.futurebim.gui.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.gui.model.GuiLoggedData;
import com.futurebim.gui.model.futurebim.GuiUser;

@Service
public class GuiLoggedDataService {

  @Autowired
  private HttpSession session;

  public GuiLoggedData getLoggedData(){

    final GuiLoggedData data = (GuiLoggedData) session.getAttribute("loggedData");

    if(data != null)
    {
      data.resetLoggedTime();
    }
    return data;
  }

  public boolean isLoggedIn(){

    final GuiLoggedData data = (GuiLoggedData) session.getAttribute("loggedData");

    return data != null;
  }

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
