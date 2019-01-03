package com.futurebim.gui.helper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futurebim.gui.model.ui.GuiMenuItem;

@Service
public interface IPageMenuLoader {
  
  public List<GuiMenuItem> getTopMenus(final String activeMenuId);

  public List<GuiMenuItem> getLeftMenus(final String routUrl, final String activeMenuId);

}
