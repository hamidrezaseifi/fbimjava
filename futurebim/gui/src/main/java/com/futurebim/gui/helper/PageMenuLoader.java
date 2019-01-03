package com.futurebim.gui.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.futurebim.gui.model.ui.GuiMenuItem;

@Service
public class PageMenuLoader implements IPageMenuLoader {

  private final List<GuiMenuItem> topMenus  = new ArrayList<>();
  private final List<GuiMenuItem> leftMenus = new ArrayList<>();

  public PageMenuLoader() {
    topMenus.add(new GuiMenuItem("menu.home", "Home", "home", "/"));
    topMenus.add(new GuiMenuItem("menu.bim", "Bim", "aspect_ratio", "/bim/"));
    topMenus.add(new GuiMenuItem("menu.projects", "Projekte", "chrome_reader_mode", "/projects/", true));
    topMenus.add(new GuiMenuItem("menu.workflow", "Workflow", "assessment", "/workflow/"));
    topMenus.add(new GuiMenuItem("menu.ifc", "IFC Viewer", "perm_media", "/ifc/"));
    topMenus.add(new GuiMenuItem("menu.settings", "Einstellung", "settings", "/options/"));

    leftMenus.add(new GuiMenuItem("menu.balance", "Balance", "account_balance", "/balance"));
    leftMenus.add(new GuiMenuItem("menu.alarm", "Alarm", "alarm_on", "/alarm"));
    leftMenus.add(new GuiMenuItem("menu.settings", "Konfiguration", "build", "/settings", true));
    leftMenus.add(new GuiMenuItem("menu.code", "Entwicklung", "code", "/code"));
    leftMenus.add(new GuiMenuItem("menu.questions", "Fragen", "help_outline", "/questions"));
    leftMenus.add(new GuiMenuItem("menu.moves", "Bewegungen", "open_with", "/moves"));
  }

  @Override
  public List<GuiMenuItem> getTopMenus(final String activeMenuId) {
    for (final GuiMenuItem ms : topMenus) {
      ms.setActive(false);
      if (ms.getId().equals(activeMenuId)) {
        ms.setActive(true);
      }
    }

    return topMenus;
  }

  @Override
  public List<GuiMenuItem> getLeftMenus(final String routUrl, final String activeMenuId) {

    final List<GuiMenuItem> menus = new ArrayList<>();

    for (final GuiMenuItem ms : leftMenus) {
      final GuiMenuItem m = ms.clone();
      m.setUrl(routUrl + m.getUrl());
      m.setActive(false);
      if (m.getId().equals(activeMenuId)) {
        m.setActive(true);
      }
      menus.add(m);
    }

    return menus;
  }

}
