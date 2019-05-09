package com.futurebim.gui.helper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.futurebim.gui.model.ui.GuiSystemMenuItem;

@Service
public interface IPageMenuLoader {
  
  public List<GuiSystemMenuItem> getTopMenus(final String url);

  public List<GuiSystemMenuItem> getLeftMenus(final String url);

  public List<GuiSystemMenuItem> getLeftMenusById(final String id, final String url);

}
