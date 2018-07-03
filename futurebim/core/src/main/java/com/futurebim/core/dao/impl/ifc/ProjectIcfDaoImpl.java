package com.futurebim.core.dao.impl.ifc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.ifc.ProjectIcfDao;
import com.futurebim.core.model.ifc.ProjectIfc;

@Transactional
@Repository
public class ProjectIcfDaoImpl implements ProjectIcfDao {

  private static final Logger logger = LoggerFactory.getLogger(ProjectIcfDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public ProjectIfc addProjectIfc(final ProjectIfc pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    session.save(pifc);
    logger.info("ProjectIfc saved successfully, ProjectIfc Details=" + pifc);
    return getById(pifc.getId());
  }

  @Override
  public boolean updateProjectIfc(final ProjectIfc pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    final ProjectIfc uc = (ProjectIfc) session.merge(pifc);
    logger.info("ProjectIfc updated successfully, ProjectIfc Details=" + pifc);
    return uc != null;
  }

  @Override
  public boolean removeProjectIfc(final Long id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final ProjectIfc pifc = session.get(ProjectIfc.class, id);

    if (null != pifc) {
      session.delete(pifc);
      logger.info("ProjectIfc deleted successfully, ProjectIfc details=" + pifc);
    }
    else {
      logger.info("ProjectIfc not found!");
      return false;
    }

    return session.get(ProjectIfc.class, id) == null;
  }

  @Override
  public ProjectIfc getById(final String id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final ProjectIfc pifc = session.get(ProjectIfc.class, id);
    if (pifc != null) {
      logger.info("ProjectIfc loaded successfully, ProjectIfc details=" + pifc);
    }
    else {
      logger.info("ProjectIfc not found!");
    }
    // session.disconnect();
    // session.close();

    return pifc;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<ProjectIfc> listProjectIfcs(final Long projectId) {
    logger.info("Read ProjectIfc List");
    final Session session = this.sessionFactory.getCurrentSession();
    final Query<ProjectIfc> query = session.createQuery("from ProjectIfc where projectId = :pid ");
    query.setParameter("pid", projectId);
    final List<ProjectIfc> personsList = query.list();

    // final List<ProjectIfc> personsList = session.createQuery("from ProjectIfc").list();

    return personsList;
  }

}
