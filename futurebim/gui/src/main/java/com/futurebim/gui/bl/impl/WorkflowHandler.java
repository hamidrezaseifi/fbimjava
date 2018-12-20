package com.futurebim.gui.bl.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.WorkflowEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IWorkflowHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiWorkflow;

@Service
public class WorkflowHandler implements IWorkflowHandler {
  
  private final Logger logger = LoggerFactory.getLogger(WorkflowHandler.class);

  @Autowired
  MessagesHelper messagesHelper;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;
  
  @Autowired
  private IUiRestTemplateCall restTemplateCall;
  
  @Autowired
  private IUserHandler userHandler;
  
  public WorkflowHandler() {

  }
  
  @Override
  public GuiWorkflow getById(final Long id) {
    logger.debug("get workflow from core");
    
    final WorkflowEdo workflowEdo = restTemplateCall.callRestGet(coreAccessConfig.getWorkflowRead(), EModule.CORE, WorkflowEdo.class, true, id);
    
    final GuiWorkflow workflow = GuiWorkflow.fromEdo(workflowEdo);
    
    return prepareWorkflow(workflow);
  }
  
  @Override
  public List<GuiWorkflow> list(final Long projectId) {
    logger.debug("get workflow list from core");

    final ParameterizedTypeReference<FBCollectionEdo<WorkflowEdo>> typeRef = new ParameterizedTypeReference<FBCollectionEdo<WorkflowEdo>>() {
    };

    final FBCollectionEdo<WorkflowEdo> projectsEdo = restTemplateCall.callRestGet(coreAccessConfig.getWorkflowReadAll(), EModule.CORE, typeRef, true, projectId);

    final List<GuiWorkflow> list = GuiWorkflow.fromEdoList(projectsEdo.getItems());

    for (final GuiWorkflow project : list) {
      prepareWorkflow(project);
    }
    return list;
  }
  
  @Override
  public GuiWorkflow save(final GuiWorkflow workflow) {
    logger.debug("save projects into core");
    
    final WorkflowEdo projectEdo = restTemplateCall.callRestPost(coreAccessConfig.getWorkflowSave(), EModule.CORE, workflow.toEdo(), WorkflowEdo.class, true);

    return GuiWorkflow.fromEdo(projectEdo);
  }
  
  @Override
  public boolean delete(final GuiWorkflow workflow) {
    logger.debug("delete projects into core");

    restTemplateCall.callRestPost(coreAccessConfig.getWorkflowDelete(), EModule.CORE, workflow.toEdo(), Void.class, true);

    return true;
  }

  private GuiWorkflow prepareWorkflow(final GuiWorkflow workflow) {
    return workflow.setResponsibleUser(userHandler.getById(workflow.getResponsible())).setReporterUser(userHandler.getById(workflow.getReporter())).setStatusName(getWorkflowStatusName(workflow.getStatus())).setTypeName(getWorkflowTypeName(workflow.getType()));
  }
  
  @Override
  public String getWorkflowStatusName(final int status) {
    return messagesHelper.get("workflow.statustitle" + status);
  }
  
  @Override
  public String getWorkflowTypeName(final int type) {
    return messagesHelper.get("workflow.typetitle" + type);
  }
  
}
