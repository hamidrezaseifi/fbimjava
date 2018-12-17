package com.featurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.featurebim.core.dao.ProjectRoleDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.dao.utils.SqlUtils;
import com.featurebim.core.model.ProjectRole;

@Transactional
@Repository
public class ProjectRoleDaoImpl implements ProjectRoleDao {

  private static final Logger              logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;
  
  @Autowired
  public ProjectRoleDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public ProjectRole addProjectRole(final ProjectRole role) throws StorageException {
    logger.debug("inser Project Role with id {}...", role.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      final String sql = "INSERT INTO project_roles (companyid, name, created_by, version, status) VALUES (?, ?, ?, ?, ?)";

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, role.getCompanyid());
        ps.setString(2, role.getName());
        ps.setLong(3, role.getCreatedBy());
        ps.setInt(4, role.getVersion());
        ps.setInt(5, role.getStatus());
        
        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Project role [name: {}]: {}", role.getName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(keyHolder.getKey().longValue());
  }

  @Override
  public ProjectRole updateProjectRole(final ProjectRole role) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean removeProjectRole(final Long id) throws StorageException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ProjectRole getById(final Long id) throws StorageException {
    logger.info("Dao Read Project role by id: " + id);
    final String sqlSelect = "SELECT * FROM project_roles where id=?";

    ProjectRole role;

    try {

      role = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return projectroleFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Project role data: " + e.toString());
    }

    return role;
  }

  @Override
  public List<ProjectRole> listProjectRoles() throws StorageException {
    logger.info("Dao Read Project roles for company List");
    final String sqlSelect = "SELECT * FROM project_roles";

    List<ProjectRole> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);

        return ps;

      }, (rs, rowNum) -> {

        return projectroleFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project roles: " + e.toString());
    }

    return list;
  }

  @Override
  public List<ProjectRole> listCompanyProjectRoles(final Long companyId) throws StorageException {
    logger.info("Dao Read Project roles for company List");
    final String sqlSelect = "SELECT * FROM project_roles where companyid=?";

    List<ProjectRole> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;

      }, (rs, rowNum) -> {

        return projectroleFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project roles: " + e.toString());
    }

    return list;
  }
  
  private ProjectRole projectroleFromResultSet(final ResultSet rs) throws SQLException {
    final ProjectRole role = new ProjectRole();

    role.setCompanyid(rs.getLong("companyid"));
    role.setCreatedBy(rs.getLong("created_by"));
    role.setVersion(rs.getInt("version"));
    role.setName(rs.getString("name"));
    role.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    role.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    role.setId(rs.getLong("id"));
    role.setVersion(rs.getInt("version"));
    role.setStatus(rs.getInt("status"));

    return role;
  }

}
