package com.futurebim.core.bl.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.core.bl.ISystemMenuHandler;
import com.futurebim.core.dao.SystemMenuDao;
import com.futurebim.core.model.SystemMenuItem;

@Service
public class SystemMenuHandler implements ISystemMenuHandler {

  @Autowired
  private SystemMenuDao systemMenuDao;

  public SystemMenuHandler() {

  }
  
  @Override
  public SystemMenuItem getRootMenu() throws Exception {
    final List<SystemMenuItem> list = systemMenuDao.listMenus();
    
    final SystemMenuItem root = findById(list, SystemMenuItem.ROOTMENU_ID);
    root.setChildren(findAllChildren(list, root.getId()));
    return root;
  }
  
  private SystemMenuItem findById(final List<SystemMenuItem> list, final String id) {
    
    for (final SystemMenuItem menu : list) {
      if (menu.getId().toLowerCase().equals(id.toLowerCase())) {
        return menu;
      }
    }
    return null;
  }
  
  private List<SystemMenuItem> findAllChildren(final List<SystemMenuItem> list, final String parentid) {
    
    final List<SystemMenuItem> children = new ArrayList<>();
    
    for (final SystemMenuItem menu : list) {
      if (menu.getParebtid().toLowerCase().equals(parentid.toLowerCase())) {

        final List<SystemMenuItem> subChildren = findAllChildren(list, menu.getId());
        menu.setChildren(subChildren);
        children.add(menu);
      }
    }
    return children;
  }
  
}
