package com.featurebim.gui.authentication;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.featurebim.gui.bl.ICompanyHandler;
import com.featurebim.gui.bl.IProjectsHandler;
import com.featurebim.gui.model.futurebim.GuiCompany;
import com.featurebim.gui.model.futurebim.GuiProjectRole;
import com.featurebim.gui.model.futurebim.GuiUserFull;
import com.featurebim.gui.model.ui.UiSessionUserInfo;

/**
 * A class to manage session-in user in session and Spring SecurityContext
 *
 * @author rezasei
 *
 */
@Service
public class UiSessionUserService {
  
  @Autowired
  private DebugModeAuthentication debugModeAuthentication;

  @Autowired
  ICompanyHandler companyHandler;
  
  @Autowired
  IProjectsHandler projectsHandler;

  @Autowired
  private UiSessionUserInfo sessionUserInfo;
  
  /**
   * this function check the from remote server authenticated user if it has access to mdm or not and if has, it will set in session and if
   * setContext is set it create the security context too
   *
   * @param username
   * @param session
   * @param setContext
   * @return the new UiSessionUserInfo or null
   */
  public UiSessionUserInfo authorizeUser(final FBAuthenticationToken token, final HttpSession session, final boolean setContext) {
    
    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return setLoggedInUserInfo(token.getUser(), session);
    
  }
  
  public UiSessionUserInfo setLoggedInUserInfo(final GuiUserFull user, final HttpSession session) {
    
    GuiCompany           company = null;
    List<GuiProjectRole> roles   = null;
    try {
      company = companyHandler.getById(user.getCompanyid());
      roles = projectsHandler.listProjectRoles(company.getId());
    }
    catch (final Exception e) {
    }
    if (company == null) {
      return null;
    }
    sessionUserInfo.setCompany(company);
    sessionUserInfo.setUser(user);
    sessionUserInfo.setProjectRoles(roles);

    return sessionUserInfo;
  }
  
  public void reloadProjectRoles(final HttpSession session) {
    
    List<GuiProjectRole> roles = null;

    roles = projectsHandler.listProjectRoles(sessionUserInfo.getCompany().getId());
    sessionUserInfo.setProjectRoles(roles);
    
  }
  
  public static void unsetLoggedUserInfo(final HttpSession session) {
    
    session.invalidate();
  }
}
