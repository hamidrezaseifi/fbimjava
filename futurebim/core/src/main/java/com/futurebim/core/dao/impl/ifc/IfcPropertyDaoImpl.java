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

import com.futurebim.core.dao.ifc.IfcPropertyDao;
import com.futurebim.core.model.ifc.IfcProperty;

@Transactional
@Repository
public class IfcPropertyDaoImpl implements IfcPropertyDao {

  private static final Logger logger = LoggerFactory.getLogger(IfcPropertyDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public IfcProperty addIfcProperty(final IfcProperty pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    session.save(pifc);
    logger.info("IfcProperty saved successfully, IfcProperty Details=" + pifc);

    return getById(pifc.getId());
  }

  @Override
  public boolean updateIfcProperty(final IfcProperty pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcProperty uc = (IfcProperty) session.merge(pifc);
    logger.info("IfcProperty updated successfully, IfcProperty Details=" + pifc);
    return uc != null;
  }

  @Override
  public boolean removeIfcProperty(final String id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcProperty pifc = session.get(IfcProperty.class, id);

    if (null != pifc) {
      session.delete(pifc);
      logger.info("IfcProperty deleted successfully, IfcProperty details=" + pifc);
    }
    else {
      logger.info("IfcProperty not found!");
      return false;
    }

    return session.get(IfcProperty.class, id) == null;
  }

  @Override
  public IfcProperty getById(final String id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcProperty pifc = session.get(IfcProperty.class, id);
    if (pifc != null) {
      logger.info("IfcProperty loaded successfully, IfcProperty details=" + pifc);
    }
    else {
      logger.info("IfcProperty not found!");
    }
    // session.disconnect();
    return pifc;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<IfcProperty> listIfcProperties(final String ifcId) {
    logger.info("Read IfcProperty List");
    final Session session = this.sessionFactory.getCurrentSession();
    final Query<IfcProperty> query = session.createQuery("from IfcProperty where ifcId = :pid ");
    query.setParameter("pid", ifcId);
    final List<IfcProperty> personsList = query.list();

    // final List<IfcProperty> personsList = session.createQuery("from IfcProperty").list();

    return personsList;
  }

}
