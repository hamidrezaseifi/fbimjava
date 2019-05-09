package com.futurebim.gui.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurebim.gui.model.ui.GuiSystemMenuItem;

@Service
public class PageMenuLoader implements IPageMenuLoader {
  
  List<GuiSystemMenuItem> topMenus = new ArrayList<>();
  // private final List<GuiSystemMenuItem> leftMenus = new ArrayList<>();
  
  private final Logger logger = LoggerFactory.getLogger(PageMenuLoader.class);
  
  @Autowired
  MessagesHelper messages;
  
  @Autowired
  private ResourceLoader resourceLoader;
  
  @Autowired
  private ObjectMapper objectMapper;
  
  public PageMenuLoader() {
    
  }
  
  @PostConstruct
  public boolean reload() throws IOException {
    
    logger.debug("load navigation from json");
    
    List<GuiSystemMenuItem> menus = new ArrayList<>();
    
    final Resource resource = resourceLoader.getResource("classpath:json/nav.json");
    try (final InputStream is = resource.getInputStream()) {
      menus = objectMapper.readValue(is, new TypeReference<List<GuiSystemMenuItem>>() {
      });
    }
    
    Collections.sort(menus);
    topMenus = menus.stream().filter(m -> m.isRoot()).filter(m -> m.getState()).collect(Collectors.toList());
    Collections.sort(topMenus);

    topMenus.forEach(menu -> menu.setLabel(messages.get(menu.getLabel())));

    for (final GuiSystemMenuItem menu : topMenus) {
      menu.setChildren(menus.stream().filter(sm -> menu.getId().equals(sm.getParent()) && sm.getState()).collect(Collectors.toList()));
      Collections.sort(menu.getChildren());
    }

    topMenus.forEach(menu -> menu.getChildren().forEach(smenu -> smenu.setLabel(messages.get(smenu.getLabel()))));
    
    return true;
  }
  
  @Override
  public List<GuiSystemMenuItem> getTopMenus(final String url) {
    
    for (final GuiSystemMenuItem ms : topMenus) {
      ms.setActive(ms.isCurrentMenu(url));
    }
    
    return topMenus;
  }
  
  @Override
  public List<GuiSystemMenuItem> getLeftMenus(final String url) {
    
    List<GuiSystemMenuItem> list = new ArrayList<>();
    for (final GuiSystemMenuItem ms : topMenus) {
      if (ms.isCurrentMenu(url)) {
        list = ms.getChildren();
        break;
      }

    }
    
    Collections.sort(list);
    list.forEach(menu -> menu.setActive(menu.isCurrentMenu(url)));

    return list;
  }
  
  @Override
  public List<GuiSystemMenuItem> getLeftMenusById(final String id, final String url) {
    List<GuiSystemMenuItem> list = new ArrayList<>();
    for (final GuiSystemMenuItem ms : topMenus) {
      if (ms.getId().equals(id)) {
        list = ms.getChildren();
        break;
      }

    }
    
    Collections.sort(list);
    list.forEach(menu -> menu.setActive(menu.isCurrentMenu(url)));

    return list;
  }
  
}
