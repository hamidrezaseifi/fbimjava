package com.featurebim.gui.authentication;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.FBAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.featurebim.gui.model.futurebim.GuiUser;
import com.featurebim.gui.model.ui.UiSessionUserInfo;
import com.featurebim.gui.model.ui.UiUser;
import com.featurebim.gui.model.ui.enums.EUiUserRole;

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

  @Value("${server.session.timeout}")
  private int sessionTimeOut;

  public UiSessionUserInfo getUserFromSession(final HttpSession session) {

    final Object oUser = session.getAttribute(UiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY);

    if (oUser != null && oUser instanceof UiSessionUserInfo) {
      final UiSessionUserInfo userInfo = (UiSessionUserInfo) oUser;

      if (userInfo.isValid(sessionTimeOut)) {
        userInfo.update();
        // session.setMaxInactiveInterval(sessionTimeOut);
        return userInfo;
      }
      else {

        session.invalidate();
        SecurityContextHolder.clearContext();
      }

    }
    else {

      if (debugModeAuthentication.isDebugLoginEnabled()) {

        final GuiUser user = new GuiUser();
        user.setUsername(debugModeAuthentication.getCurrentDebugLoginUsername());
        final EUiUserRole[] roles = new EUiUserRole[1];
        roles[0] = EUiUserRole.ADMIN;
        return authorizeUser(new FBAuthenticationToken(user), session, true);

      }
      else {
        session.invalidate();
        SecurityContextHolder.clearContext();
      }

    }

    return null;
  }

  /**
   * this function check the from remote server authenticated user if it has access to mdm or not and if has, it will set in session and if
   * setContext is set it create the security context too
   *
   * @param username
   * @param session
   * @param setContext
   * @return the new UiSessionUserInfo or null
   */
  public UiSessionUserInfo authorizeUser(final FBAuthenticationToken token,
                                         final HttpSession session,
                                         final boolean setContext) {

    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return setLoggedInUserInfo(new UiUser(token.getUser(), new ArrayList<>()), session);

  }

  public UiSessionUserInfo setLoggedInUserInfo(final UiUser user, final HttpSession session) {

    session.setAttribute(UiSessionUserInfo.SESSION_LOGGEDUSERINFO_KEY, new UiSessionUserInfo(user));

    return getUserFromSession(session);
  }

  public static void unsetLoggedUserInfo(final HttpSession session) {

    session.invalidate();
  }
}
