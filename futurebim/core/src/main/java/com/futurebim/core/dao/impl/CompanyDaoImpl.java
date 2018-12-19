package com.futurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import com.futurebim.core.dao.CompanyDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.CompanyEmail;
import com.futurebim.core.model.CompanyPhoneNumber;
import com.futurebim.core.model.CompanyPostalAddress;

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

      final String sql = "INSERT INTO companies (identname, company_name, comments, status, version) VALUES (?, ?, ?, ?, ?)";
      //@formatter:on

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, company.getIdentname());
        ps.setString(2, company.getCompanyName());
        ps.setString(3, company.getComments());
        ps.setInt(4, company.getStatus());
        ps.setInt(5, company.getVersion());

        return ps;
      }, keyHolder);

      company.setId(keyHolder.getKey().longValue());
      
      updateCompanyPostalAddress(company);
      updateCompanyPhoneNumbers(company);
      updateCompanyEmails(company);
      updateCompanyContactPersons(company);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert company [name: {}]: {}", company.getCompanyName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }

  @Override
  public Company updateCompany(final Company company) throws StorageException {
    logger.debug("Updating company with id {}...", company.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "UPDATE companies SET identname = ?, company_name = ?, comments = ?, status = ?, version = ? WHERE id = ?";
      //@formatter:on

      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, company.getIdentname());
        ps.setString(2, company.getCompanyName());
        ps.setString(3, company.getComments());
        ps.setInt(4, company.getStatus());
        ps.setInt(5, company.getVersion());
        ps.setLong(6, company.getId());

        return ps;
      });

      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update company [id: {}]", company.getId()));
      }

      updateCompanyPostalAddress(company);
      updateCompanyPhoneNumbers(company);
      updateCompanyEmails(company);
      updateCompanyContactPersons(company);
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update company [id: {}]: {}", company.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }
  
  private Company updateCompanyPostalAddress(final Company company) throws StorageException {
    logger.debug("Updating company Postal Address with id {}...", company.getId());
    try {

      final String delSql = "delete from company_postaladdresses WHERE companyid = ?";

      jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(delSql);
        ps.setLong(1, company.getId());

        return ps;
      });

      final String insertSql = "INSERT INTO company_postaladdresses (companyid, address_name, country, city, postcode, street, house_number, additional_address, comments, status, version) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      for (final CompanyPostalAddress model : company.getPostalAddress()) {

        jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(insertSql);
          ps.setLong(1, company.getId());
          ps.setString(2, model.getAddressName());
          ps.setString(3, model.getCountry());
          ps.setString(4, model.getCity());
          ps.setString(5, model.getPostcode());
          ps.setString(6, model.getStreet());
          ps.setString(7, model.getHouseNumber());
          ps.setString(8, model.getAdditionalAddress());
          ps.setString(9, model.getComments());
          ps.setInt(10, model.getStatus());
          ps.setInt(11, model.getVersion());

          return ps;
        });
      }

    }
    catch (final Exception e) {
      logger.error("Unable to update company Postal Address [id: {}]: {}", company.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }

  private Company updateCompanyPhoneNumbers(final Company company) throws StorageException {
    logger.debug("Updating company Phone Numbers with id {}...", company.getId());
    try {
      
      final String delSql = "delete from company_phonesnumbers WHERE companyid = ?";
      
      jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(delSql);
        ps.setLong(1, company.getId());
        
        return ps;
      });
      
      final String insertSql = "INSERT INTO company_phonesnumbers (companyid, telephone_name, phonenumner, comments, status, version) VALUES (?, ?, ?, ?, ?, ?)";
      
      for (final CompanyPhoneNumber model : company.getPhoneNumbers()) {
        
        jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(insertSql);
          ps.setLong(1, company.getId());
          ps.setString(2, model.getTelephoneName());
          ps.setString(3, model.getPhonenumner());
          ps.setString(4, model.getComments());
          ps.setInt(5, model.getStatus());
          ps.setInt(6, model.getVersion());
          
          return ps;
        });
      }
      
    }
    catch (final Exception e) {
      logger.error("Unable to update company Phone Numbers [id: {}]: {}", company.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }
  
  private Company updateCompanyEmails(final Company company) throws StorageException {
    logger.debug("Updating company Emails with id {}...", company.getId());
    try {
      
      final String delSql = "delete from company_emails WHERE companyid = ?";
      
      jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(delSql);
        ps.setLong(1, company.getId());
        
        return ps;
      });
      
      final String insertSql = "INSERT INTO company_emails (companyid, email_name, emailaddress, comments, status, version) VALUES (?, ?, ?, ?, ?, ?)";
      
      for (final CompanyEmail model : company.getEmails()) {
        
        jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(insertSql);
          ps.setLong(1, company.getId());
          ps.setString(2, model.getEmailName());
          ps.setString(3, model.getEmail());
          ps.setString(4, model.getComments());
          ps.setInt(5, model.getStatus());
          ps.setInt(6, model.getVersion());
          
          return ps;
        });
      }
      
    }
    catch (final Exception e) {
      logger.error("Unable to update company Emails [id: {}]: {}", company.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(company.getId());
  }
  
  private Company updateCompanyContactPersons(final Company company) throws StorageException {
    logger.debug("Updating company Contact Persons with id {}...", company.getId());
    try {
      
      final String delSql = "delete from company_contact_person WHERE companyid = ?";
      
      jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(delSql);
        ps.setLong(1, company.getId());
        
        return ps;
      });
      
      final String insertSql = "INSERT INTO company_contact_person (companyid, userid) VALUES (?, ?)";
      
      for (final Long userid : company.getContactPersons()) {
        
        jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(insertSql);
          ps.setLong(1, company.getId());
          ps.setLong(2, userid);
          
          return ps;
        });
      }
      
    }
    catch (final Exception e) {
      logger.error("Unable to update company Contact Persons [id: {}]: {}", company.getId(), e.toString(), e);
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
          try {
            return companyFromResultSet(rs);
          }
          catch (final StorageException e) {
            return null;
          }
        }
        else {
          return null;
        }
      });
      
      if (company == null) {
        throw new StorageException(String.format("Unable to retrieve Company detail companyid:{} ", id));
      }
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
        try {
          return companyFromResultSet(rs);
        }
        catch (final StorageException e) {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve companies: " + e.toString());
    }

    return list;

  }

  private Company companyFromResultSet(final ResultSet rs) throws SQLException, StorageException {
    final Company company = new Company();
    company.setComments(rs.getString("comments"));
    company.setIdentname(rs.getString("identname"));
    company.setCompanyName(rs.getString("company_name"));
    company.setCreated(rs.getTimestamp("created").toLocalDateTime());
    company.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    company.setId(rs.getLong("id"));
    company.setVersion(rs.getInt("version"));
    company.setStatus(rs.getInt("status"));
    company.setPhoneNumbers(listCompanyPhoneNumbers(company.getId()));
    company.setPostalAddresses(listCompanyPostalAddresses(company.getId()));
    company.setEmails(listCompanyEmails(company.getId()));
    company.setContactPersons(listCompanyContactPersons(company.getId()));
    
    return company;
  }

  @Override
  public List<CompanyPostalAddress> listCompanyPostalAddresses(final Long companyId) throws StorageException {
    logger.info("Dao Read Company postal address List");
    final String sqlSelect = "SELECT * FROM company_postaladdresses where companyid=?";

    List<CompanyPostalAddress> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return postalAdressFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Company postal address: " + e.toString());
    }

    return list;
  }

  @Override
  public List<CompanyPhoneNumber> listCompanyPhoneNumbers(final Long companyId) throws StorageException {
    logger.info("Dao Read Company phone numbers List");
    final String sqlSelect = "SELECT * FROM company_phonesnumbers where companyid=?";

    List<CompanyPhoneNumber> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return phoneNumberFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Company phone numbers: " + e.toString());
    }

    return list;
  }
  
  @Override
  public List<CompanyEmail> listCompanyEmails(final Long companyId) throws StorageException {
    logger.info("Dao Read Company emails List");
    final String sqlSelect = "SELECT * FROM company_emails where companyid=?";

    List<CompanyEmail> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return emailFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to Company retrieve emails: " + e.toString());
    }

    return list;
  }
  
  @Override
  public List<Long> listCompanyContactPersons(final Long companyId) throws StorageException {
    logger.info("Dao Read Company emails List");
    final String sqlSelect = "SELECT userid FROM company_contact_person where companyid=?";

    List<Long> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return rs.getLong("userid");
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to Company retrieve emails: " + e.toString());
    }

    return list;
  }

  private CompanyPostalAddress postalAdressFromResultSet(final ResultSet rs) throws SQLException {
    final CompanyPostalAddress model = new CompanyPostalAddress();
    model.setComments(rs.getString("comments"));
    model.setCreated(rs.getTimestamp("created").toLocalDateTime());
    model.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(rs.getInt("status"));
    model.setCompanyid(rs.getLong("companyid"));
    model.setAdditionalAddress(rs.getString("additional_address"));
    model.setAddressName(rs.getString("address_name"));
    model.setCity(rs.getString("city"));
    model.setCountry(rs.getString("country"));
    model.setHouseNumber(rs.getString("house_number"));
    model.setPostcode(rs.getString("postcode"));
    model.setStreet(rs.getString("street"));

    return model;
  }

  private CompanyPhoneNumber phoneNumberFromResultSet(final ResultSet rs) throws SQLException {
    final CompanyPhoneNumber model = new CompanyPhoneNumber();
    model.setComments(rs.getString("comments"));
    model.setCreated(rs.getTimestamp("created").toLocalDateTime());
    model.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(rs.getInt("status"));
    model.setCompanyid(rs.getLong("companyid"));
    model.setPhonenumner(rs.getString("phonenumner"));
    model.setTelephoneName(rs.getString("telephone_name"));

    return model;
  }

  private CompanyEmail emailFromResultSet(final ResultSet rs) throws SQLException {
    final CompanyEmail model = new CompanyEmail();
    model.setComments(rs.getString("comments"));
    model.setCreated(rs.getTimestamp("created").toLocalDateTime());
    model.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(rs.getInt("status"));
    model.setCompanyid(rs.getLong("companyid"));
    model.setEmail(rs.getString("emailaddress"));
    model.setEmailName(rs.getString("email_name"));

    return model;
  }
  
}
