package com.featurebim.gui.model.ui;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.featurebim.gui.model.futurebim.GuiUser;

/**
 * The persistent class for the users database table.
 *
 */
@Component
@Scope("session")
@SessionAttributes("loggedData")
public class GuiLoggedData implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private GuiUser user;
  private LocalDateTime loggedTime;

  public GuiLoggedData(){
    this.user = null;
    this.loggedTime = LocalDateTime.now();
  }

  public GuiLoggedData(final GuiUser user){
    this.user = user;
    this.loggedTime = LocalDateTime.now();
  }

  public GuiUser getUser() {
    return user;
  }


  public void setUser(final GuiUser user) {
    this.user = user;
  }



  public LocalDateTime getLoggedTime() {
    return loggedTime;
  }


  public void resetLoggedTime() {
    this.loggedTime = LocalDateTime.now();
  }

  public static GuiLoggedData setInSession(final HttpSession session){

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

  public static GuiLoggedData create(){


    final GuiUser user = new GuiUser();
    user.setCompanyid(1L);
    user.setId(1L);
    user.setFirstname("User");
    user.setLastname("User");

    final GuiLoggedData data = new GuiLoggedData(user);


    return data;
  }


}
