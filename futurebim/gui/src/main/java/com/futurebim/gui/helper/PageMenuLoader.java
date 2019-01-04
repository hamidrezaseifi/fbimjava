package com.futurebim.gui.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.common.model.edo.SystemMenuItemEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.model.ui.GuiSystemMenuItem;

@Service
public class PageMenuLoader implements IPageMenuLoader {

  private GuiSystemMenuItem       rootMenu = null;
  private List<GuiSystemMenuItem> topMenus = new ArrayList<>();
  // private final List<GuiSystemMenuItem> leftMenus = new ArrayList<>();

  private final Logger logger = LoggerFactory.getLogger(PageMenuLoader.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  public PageMenuLoader() {

  }

  public boolean reload() {

    logger.debug("get company from core");

    final SystemMenuItemEdo edo = restTemplateCall.callRestGet(coreAccessConfig.getAllSystemMenuUrl(), EModule.CORE, SystemMenuItemEdo.class, true);
    rootMenu = GuiSystemMenuItem.fromEdo(edo);

    topMenus = rootMenu.getChildren();
    for (final GuiSystemMenuItem menu : topMenus) {
      menu.setLabel(messages.get(menu.getLabel()));
    }

    return true;
  }

  @Override
  public List<GuiSystemMenuItem> getTopMenus(final String url) {
    if (topMenus.isEmpty()) {
      reload();
    }
    
    for (final GuiSystemMenuItem ms : topMenus) {
      ms.setActive(ms.isCurrentMenu(url));
    }

    return topMenus;
  }

  @Override
  public List<GuiSystemMenuItem> getLeftMenus(final String url) {
    if (topMenus.isEmpty()) {
      reload();
    }
    
    List<GuiSystemMenuItem> list = new ArrayList<>();
    for (final GuiSystemMenuItem ms : topMenus) {
      if (ms.isCurrentMenu(url)) {
        list = ms.getChildren();
        break;
      }
      
    }

    for (final GuiSystemMenuItem ms : list) {
      ms.setActive(ms.isCurrentMenu(url));
    }
    
    return list;
  }

}
