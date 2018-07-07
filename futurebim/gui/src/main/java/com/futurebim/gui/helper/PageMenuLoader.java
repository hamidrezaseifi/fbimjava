package com.futurebim.gui.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.futurebim.gui.model.MenuItem;

@Component
public class PageMenuLoader {
  private final List<MenuItem> topMenus = new ArrayList<>();
  private final List<MenuItem> leftMenus = new ArrayList<>();

  public PageMenuLoader()
  {
    topMenus.add(new MenuItem("menu.home" , "Home", "home" , "/"));
    topMenus.add(new MenuItem("menu.bim" , "Bim", "aspect_ratio" , "/bim/"));
    topMenus.add(new MenuItem("menu.projects" , "Projekte", "chrome_reader_mode" , "/projects/", true));
    topMenus.add(new MenuItem("menu.workflow" , "Workflow", "assessment" , "/workflow/"));
    topMenus.add(new MenuItem("menu.ifc" , "IFC Viewer", "perm_media" , "/ifc/"));
    topMenus.add(new MenuItem("menu.settings" , "Einstellung", "settings" , "/options/"));

    leftMenus.add(new MenuItem("menu.balance" , "Balance", "account_balance" , "/balance"));
    leftMenus.add(new MenuItem("menu.alarm" , "Alarm", "alarm_on" , "/alarm"));
    leftMenus.add(new MenuItem("menu.settings" , "Konfiguration", "build" , "/settings", true));
    leftMenus.add(new MenuItem("menu.code" , "Entwicklung", "code" , "/code"));
    leftMenus.add(new MenuItem("menu.questions" , "Fragen", "help_outline" , "/questions"));
    leftMenus.add(new MenuItem("menu.moves" , "Bewegungen", "open_with" , "/moves"));
  }


  public List<MenuItem> getTopMenus(final String activeMenuId) {
    for(final MenuItem ms:topMenus) {
      ms.setActive(false);
      if(ms.getId().equals(activeMenuId))
      {
        ms.setActive(true);
      }
    }

    return topMenus;
  }

  public List<MenuItem> getLeftMenus(final String routUrl, final String activeMenuId) {

    final List<MenuItem> menus = new ArrayList<>();

    for(final MenuItem ms:leftMenus) {
      final MenuItem m = ms.clone();
      m.setUrl(routUrl + m.getUrl());
      m.setActive(false);
      if(m.getId().equals(activeMenuId))
      {
        m.setActive(true);
      }
      menus.add(m);
    }

    return menus;
  }


}
