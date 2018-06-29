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

import com.futurebim.core.dao.ifc.IfcPropertySingleValueDao;
import com.futurebim.core.model.ifc.IfcPropertySingleValue;

@Transactional
@Repository
public class IfcPropertySingleValueImpl implements IfcPropertySingleValueDao {

  private static final Logger logger = LoggerFactory.getLogger(IfcPropertySingleValueImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public IfcPropertySingleValue addIfcPropertySingleValue(final IfcPropertySingleValue pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    session.save(pifc);
    logger.info("IfcPropertySingleValue saved successfully, IfcPropertySingleValue Details=" + pifc);
    return getById(pifc.getId());
  }

  @Override
  public boolean updateIfcPropertySingleValue(final IfcPropertySingleValue pifc) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcPropertySingleValue uc = (IfcPropertySingleValue) session.merge(pifc);
    logger.info("IfcPropertySingleValue updated successfully, IfcPropertySingleValue Details=" + pifc);
    return uc != null;
  }

  @Override
  public boolean removeIfcPropertySingleValue(final String id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcPropertySingleValue pifc = session.get(IfcPropertySingleValue.class, id);

    if (null != pifc) {
      session.delete(pifc);
      logger.info("IfcPropertySingleValue deleted successfully, IfcPropertySingleValue details=" + pifc);
    }
    else {
      logger.info("IfcPropertySingleValue not found!");
      return false;
    }

    return session.get(IfcPropertySingleValue.class, id) == null;
  }

  @Override
  public IfcPropertySingleValue getById(final Long id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final IfcPropertySingleValue pifc = session.get(IfcPropertySingleValue.class, id);
    if (pifc != null) {
      logger.info("IfcPropertySingleValue loaded successfully, IfcPropertySingleValue details=" + pifc);
    }
    else {
      logger.info("IfcPropertySingleValue not found!");
    }
    session.disconnect();
    return pifc;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<IfcPropertySingleValue> listIfcPropertyValues(final String ifcpropId) {
    logger.info("Read IfcPropertySingleValue List");
    final Session session = this.sessionFactory.getCurrentSession();
    final Query<IfcPropertySingleValue> query = session.createQuery("from IfcPropertySingleValue where ifcProperty = :pid ");
    query.setParameter("pid", ifcpropId);
    final List<IfcPropertySingleValue> personsList = query.list();

    // final List<IfcPropertySingleValue> personsList = session.createQuery("from IfcPropertySingleValue").list();

    return personsList;
  }

}
