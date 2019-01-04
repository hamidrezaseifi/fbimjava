package com.futurebim.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.SystemMenuDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.dao.utils.SqlUtils;
import com.futurebim.core.model.SystemMenuItem;

@Transactional
@Repository
@Qualifier("SystemMenuDaoImpl")
public class SystemMenuDaoImpl implements SystemMenuDao {
  
  private static final Logger logger = LoggerFactory.getLogger(SystemMenuDaoImpl.class);
  
  private final JdbcTemplate jdbcTemplate;

  private final PlatformTransactionManager platformTransactionManager;

  @Autowired
  SystemMenuDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }
  
  @Override
  public SystemMenuItem getById(final Long id) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public SystemMenuItem add(final SystemMenuItem item) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public SystemMenuItem update(final SystemMenuItem item) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public boolean delete(final Long id) throws StorageException {
    // TODO Auto-generated method stub
    return false;
  }
  
  @Override
  public List<SystemMenuItem> listMenus() throws StorageException {
    logger.info("Dao Read Menu List");
    final String sqlSelect = "SELECT * FROM navigation order by parent, sort";
    
    List<SystemMenuItem> list = new ArrayList<>();
    
    try {
      list = this.jdbcTemplate.query(sqlSelect, (RowMapper<SystemMenuItem>) (rs, rowNum) -> {
        try {
          return menuFromResultSet(rs);
        }
        catch (final StorageException e) {
          return null;
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Menu list: " + e.toString());
    }
    
    return list;
  }
  
  private SystemMenuItem menuFromResultSet(final ResultSet rs) throws SQLException {
    final SystemMenuItem model = new SystemMenuItem();

    model.setId(rs.getString("id"));
    model.setImage(rs.getString("image"));
    model.setLabel(rs.getString("label"));
    model.setState(rs.getInt("state"));
    model.setUrl(rs.getString("url"));
    model.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    model.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    model.setVersion(rs.getInt("version"));
    model.setParebtid(rs.getString("parent"));
    model.setSort(rs.getInt("sort"));

    return model;
  }

}
