package com.featurebim.gui.controller.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.featurebim.gui.model.MenuItem;

@Controller
public abstract class UiControllerBase {



  protected abstract List<MenuItem> getTopToolbar();

  protected abstract List<MenuItem> getLeftToolbar();

  protected abstract String getActiveLeftToolbarId();


  protected String getCurrentRelatedUrl() {
    ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
    final String root = builder.build().toUriString();
    builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
    String path = builder.build().toUriString();
    path = path.replace(root, "");

    return path;
  }

  @ModelAttribute
  public void addAttributes(final Model model,final HttpServletRequest request) {
    model.addAttribute("pageTopToolList", getTopToolbar());
    model.addAttribute("pageLeftToolList", getLeftToolbar());



  }
}
