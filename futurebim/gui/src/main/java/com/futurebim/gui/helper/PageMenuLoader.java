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
    topMenus.add(new MenuItem("menu.bim" , "Bim", "aspect_ratio" , "#"));
    topMenus.add(new MenuItem("menu.projects" , "Projekte", "chrome_reader_mode" , "#", true));
    topMenus.add(new MenuItem("menu.workflow" , "Workflow", "assessment" , "#"));
    topMenus.add(new MenuItem("menu.settings" , "Einstellung", "settings" , "#"));

    leftMenus.add(new MenuItem("menu.bim" , "Balance", "account_balance" , "#"));
    leftMenus.add(new MenuItem("menu.projects" , "Alarm", "alarm_on" , "#"));
    leftMenus.add(new MenuItem("menu.workflow" , "Konfiguration", "build" , "#", true));
    leftMenus.add(new MenuItem("menu.settings" , "Entwicklung", "code" , "#"));
    leftMenus.add(new MenuItem("menu.settings" , "Fragen", "help_outline" , "#"));
    leftMenus.add(new MenuItem("menu.settings" , "Bewegungen", "open_with" , "#"));
  }


  public List<MenuItem> getTopMenus() {
    return topMenus;
  }

  public List<MenuItem> getLeftMenus() {
    return leftMenus;
  }


}
