package com.featurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.featurebim.core.dao.CompanyStatusDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.CompanyStatusItem;
import com.featurebim.core.model.CompanyStatusList;

@Transactional
@Repository
@Qualifier("CompanyStatusDaoImpl")
public class CompanyStatusDaoImpl implements CompanyStatusDao {

  private static final Logger logger = LoggerFactory.getLogger(CompanyStatusDaoImpl.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  CompanyStatusDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public CompanyStatusItem getById(final int id) throws StorageException {
    logger.info("Dao Read CompanyStatus by id: " + id);
    final String sqlSelect = "SELECT * FROM company_status where id=?";

    CompanyStatusItem status;

    try {

      status = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return new CompanyStatusItem(rs.getInt("id"), rs.getString("titleid"));
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve company data: " + e.toString());
    }

    return status;
  }

  @Override
  public CompanyStatusList listStatus() throws StorageException {
    logger.info("Dao Read Company Status List");
    final String sqlSelect = "SELECT * FROM company_status order by id";

    final CompanyStatusList list = new CompanyStatusList();

    List<CompanyStatusItem> items = new ArrayList<>();

    try {
      items = this.jdbcTemplate.query(sqlSelect, (RowMapper<CompanyStatusItem>) (rs, rowNum) -> {
        return new CompanyStatusItem(rs.getInt("id"), rs.getString("titleid"));
      });
      list.setItems(items);
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve company status list: " + e.toString());
    }

    return list;

  }

}
