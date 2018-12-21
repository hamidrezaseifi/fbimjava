package com.futurebim.gui.authentication;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.futurebim.gui.bl.ICompanyHandler;
import com.futurebim.gui.bl.IProjectsHandler;
import com.futurebim.gui.bl.IWorkflowHandler;
import com.futurebim.gui.model.futurebim.GuiCompany;
import com.futurebim.gui.model.futurebim.GuiProjectRole;
import com.futurebim.gui.model.futurebim.GuiUserFull;
import com.futurebim.gui.model.futurebim.GuiWorkflowType;
import com.futurebim.gui.model.ui.UiSessionUserInfo;

/**
 * A class to manage session-in user in session and Spring SecurityContext
 *
 * @author rezasei
 *
 */
@Service
public class UiSessionUserService {
  
  @Autowired
  ICompanyHandler companyHandler;
  
  @Autowired
  IProjectsHandler projectsHandler;
  
  @Autowired
  IWorkflowHandler workflowHandler;

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
    
    reloadSessionData(user);

    return sessionUserInfo;
  }
  
  public void reloadSessionData(final GuiUserFull user) {
    
    GuiCompany            company       = null;
    List<GuiProjectRole>  roles         = null;
    List<GuiWorkflowType> workflowTypes = null;
    
    try {
      company = companyHandler.getById(user.getCompanyid());
      roles = projectsHandler.listProjectRoles(company.getId());
      workflowTypes = workflowHandler.listTypes();
    }
    catch (final Exception e) {
    }
    
    sessionUserInfo.setCompany(company);
    sessionUserInfo.setUser(user);
    sessionUserInfo.setProjectRoles(roles);
    sessionUserInfo.setWorkflowTypes(workflowTypes);
    
  }
  
  public static void unsetLoggedUserInfo(final HttpSession session) {
    
    session.invalidate();
  }
}
