package com.futurebim.core.cach;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.stereotype.Component;

import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

@Component
public class CatchedProjectIfcManager extends Thread {

  private final List<CatchedProjectIfc> ifcList    = new ArrayList<>();
  private final AtomicBoolean           isRemoving = new AtomicBoolean(false);

  public CatchedProjectIfcManager() {
    super();

    isRemoving.set(false);
    this.start();
  }

  public CatchedProjectIfc getById(final Long id) {

    waitForRemoving();

    for (final CatchedProjectIfc ifc : ifcList) {

      if (ifc.getProjectIfcEdo().getId() == id && ifc.isValid()) {
        return ifc;
      }
    }

    return null;
  }

  public ProjectIfcEdo removeById(final Long id) {

    waitForRemoving();

    final CatchedProjectIfc ifc = getById(id);
    if (ifc != null) {
      ifcList.remove(ifc);
      return ifc.getProjectIfcEdo();
    }
    return null;
  }

  public ProjectIfcEdo removeByIfc(final ProjectIfcEdo ifcEdo) {

    waitForRemoving();

    final CatchedProjectIfc ifc = getById(ifcEdo.getId());
    if (ifc != null) {
      ifcList.remove(ifc);
      return ifc.getProjectIfcEdo();
    }
    return null;
  }

  public CatchedProjectIfc add(final ProjectIfcEdo ifcEdo) {

    removeByIfc(ifcEdo);

    waitForRemoving();

    final CatchedProjectIfc ifc = new CatchedProjectIfc(ifcEdo);
    ifcList.add(ifc);

    return ifc;
  }

  public void removeInvalids() {

    final List<CatchedProjectIfc> remList = new ArrayList<>();

    for (final CatchedProjectIfc ifc : ifcList) {

      if (!ifc.isValid()) {
        remList.add(ifc);
      }
    }

    ifcList.removeAll(remList);
  }

  @Override
  public void run() {

    isRemoving.set(false);

    while (true) {

      sleeping(5000);

      isRemoving.set(true);

      removeInvalids();

      isRemoving.set(false);

    }
  }

  private void sleeping(final int msec) {
    try {
      sleep(msec);
    }
    catch (final InterruptedException e) {

    }
  }

  private void waitForRemoving() {
    while (isRemoving.get()) {
      sleeping(50);
    }
  }
}
