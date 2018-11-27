package com.featurebim.core.dao.impl;

import java.sql.PreparedStatement;
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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.featurebim.core.dao.CompanyDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Company;

@Transactional
@Repository
@Qualifier("CompanyDaoImpl")
public class CompanyDaoImpl implements CompanyDao {

  private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  @Autowired
  CompanyDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public Company addCompany(final Company company) throws StorageException {
    logger.debug("Updating company with id {}...", company.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      final String sql = "INSERT INTO companies (company_name, comments, status, version) VALUES (?, ?, ?, ?)";
      //@formatter:on

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, company.getCompanyName());
        ps.setString(2, company.getComments());
        ps.setInt(3, company.getStatus());
        ps.setInt(4, company.getVersion());

        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert company [name: {}]: {}", company.getCompanyName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(keyHolder.getKey().longValue());
  }

  @Override
  public Company updateCompany(final Company company) throws StorageException {
    logger.debug("Updating company with id {}...", company.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "UPDATE companies SET company_name = ?, comments = ?, status = ?, version = ? WHERE id = ?";
      //@formatter:on

      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, company.getCompanyName());
        ps.setString(2, company.getComments());
        ps.setInt(3, company.getStatus());
        ps.setInt(4, company.getVersion());
        ps.setLong(5, company.getId());

        return ps;
      });

      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update company [id: {}]", company.getId()));
      }

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update company [id: {}]: {}", company.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }

  @Override
  public boolean removeCompany(final Long id) throws StorageException {
    CompanyDaoImpl.logger.debug("Deleting company with id {}...", id);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "delete from companies where id = ? ";
      //@formatter:on

      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
      });

      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to delete company  [id: {}]", id));
      }

      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }

    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      CompanyDaoImpl.logger.error("Unable to delete company [id: {}]: {}", id, e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
  }

  @Override
  public Company getById(final Long id) throws StorageException {
    logger.info("Dao Read Company by id: " + id);
    final String sqlSelect = "SELECT * FROM companies where id=?";

    Company company;

    try {

      company = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return companyFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve company data: " + e.toString());
    }

    return company;
  }

  @Override
  public List<Company> listCompanies() throws StorageException {
    logger.info("Dao Read Company List");
    final String sqlSelect = "SELECT * FROM companies";

    List<Company> list = new ArrayList<>();

    try {
      list = this.jdbcTemplate.query(sqlSelect, (RowMapper<Company>) (rs, rowNum) -> {
        return companyFromResultSet(rs);
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve companies: " + e.toString());
    }

    return list;

  }

  private Company companyFromResultSet(final ResultSet rs) throws SQLException {
    final Company company = new Company();
    company.setComments(rs.getString("comments"));
    company.setCompanyName(rs.getString("company_name"));
    company.setCreated(rs.getTimestamp("created").toLocalDateTime());
    company.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    company.setId(rs.getLong("id"));
    company.setVersion(rs.getInt("version"));
    company.setStatus(rs.getInt("status"));

    return company;
  }

}
