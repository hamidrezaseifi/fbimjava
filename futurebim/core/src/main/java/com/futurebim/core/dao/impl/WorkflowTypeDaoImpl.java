package com.futurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.WorkflowTypeDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.WorkflowType;

@Transactional
@Repository
public class WorkflowTypeDaoImpl implements WorkflowTypeDao {

  private static final Logger              logger = LoggerFactory.getLogger(WorkflowTypeDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;
  
  @Autowired
  WorkflowTypeDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public WorkflowType getById(final Long id) throws StorageException {
    logger.info("Dao Read Project by id: " + id);
    final String sqlSelect = "SELECT * FROM workflow_type where id=?";

    WorkflowType workflowType;

    try {

      workflowType = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return workflowTypeFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Project data: " + e.toString());
    }

    return workflowType;
  }

  @Override
  public List<WorkflowType> list() throws StorageException {
    logger.info("Dao Read Project Workflow List");
    final String sqlSelect = "SELECT * FROM workflow_type";

    List<WorkflowType> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        
        return ps;

      }, (rs, rowNum) -> {

        return workflowTypeFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project Workflow: " + e.toString());
    }

    return list;
  }

  private WorkflowType workflowTypeFromResultSet(final ResultSet rs) throws SQLException {
    final WorkflowType model = new WorkflowType();

    model.setId(rs.getInt("id"));
    model.setTypeName(rs.getString("name"));
    model.setIcon(rs.getString("icon"));
    model.setStatus(rs.getInt("status"));
    
    return model;
  }

}
