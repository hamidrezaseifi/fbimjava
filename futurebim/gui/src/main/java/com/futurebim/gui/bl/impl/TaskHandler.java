package com.futurebim.gui.bl.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.TaskEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.ITaskHandler;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiTask;

@Service
public class TaskHandler implements ITaskHandler {
  
  private final Logger logger = LoggerFactory.getLogger(TaskHandler.class);

  @Autowired
  MessagesHelper messagesHelper;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;
  
  @Autowired
  private IUiRestTemplateCall restTemplateCall;
  
  @Autowired
  private IUserHandler userHandler;
  
  public TaskHandler() {

  }
  
  @Override
  public GuiTask getById(final Long id) {
    logger.debug("get task from core");
    
    final TaskEdo taskEdo = restTemplateCall.callRestGet(coreAccessConfig.getTaskRead(), EModule.CORE, TaskEdo.class, true, id);
    
    final GuiTask task = GuiTask.fromEdo(taskEdo);
    
    return prepareTask(task);
  }

  @Override
  public List<GuiTask> listTasks(final Long projectId) {
    logger.debug("get task list from core");

    final ParameterizedTypeReference<FBCollectionEdo<TaskEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<TaskEdo>>() {
    };

    final FBCollectionEdo<TaskEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getTaskProjectReadAll(), EModule.CORE, typeRef, true, projectId);

    final List<GuiTask> list = GuiTask.fromEdoList(projectsEdo.getItems());

    for (final GuiTask project : list) {
      prepareTask(project);
    }
    return list;
  }

  @Override
  public List<GuiTask> listTasksByWorkflow(final Long workflowId) {
    logger.debug("get task list from core");

    final ParameterizedTypeReference<FBCollectionEdo<TaskEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<TaskEdo>>() {
    };

    final FBCollectionEdo<TaskEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getTaskWorkflowReadAll(), EModule.CORE, typeRef, true, workflowId);

    final List<GuiTask> list = GuiTask.fromEdoList(projectsEdo.getItems());

    for (final GuiTask project : list) {
      prepareTask(project);
    }
    return list;
  }
  
  @Override
  public GuiTask save(final GuiTask task) {
    logger.debug("save projects into core");
    
    final TaskEdo projectEdo = restTemplateCall.callRestPost(coreAccessConfig.getTaskSave(), EModule.CORE, task.toEdo(), TaskEdo.class, true);

    return GuiTask.fromEdo(projectEdo);
  }
  
  @Override
  public boolean delete(final GuiTask task) {
    logger.debug("delete projects into core");

    restTemplateCall.callRestPost(coreAccessConfig.getTaskDelete(), EModule.CORE, task.toEdo(), Void.class, true);

    return true;
  }

  private GuiTask prepareTask(final GuiTask task) {
    return task.setAssignedToUser(userHandler.getById(task.getAssignedTo())).setReporterUser(userHandler.getById(task.getReporter())).setStatusName(getTaskStatusName(task.getStatus()));
  }

  @Override
  public String getTaskStatusName(final int accessType) {
    return messagesHelper.get("task.statustitle" + accessType);
  }
  
}
