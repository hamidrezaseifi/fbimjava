package com.featurebim.gui.bl;

import java.util.List;

import com.featurebim.gui.model.futurebim.GuiTask;

public interface ITaskHandler {

  public GuiTask getById(final Long id);

  public List<GuiTask> listTasks(final Long projectId);

  public GuiTask save(final GuiTask task);

  public boolean delete(final GuiTask task);

}
