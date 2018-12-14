package com.featurebim.gui.bl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.featurebim.gui.model.futurebim.GuiCountry;

@Service
public class ValueHandler implements IValueHandler {

  public ValueHandler() {

  }

  @Override
  public List<GuiCountry> listCountries() {

    return Arrays.asList(new GuiCountry("DE", "Deutschland"));
  }

}
