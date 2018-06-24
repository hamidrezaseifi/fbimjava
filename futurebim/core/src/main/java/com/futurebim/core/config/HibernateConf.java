package com.futurebim.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@EnableTransactionManagement
public class HibernateConf {
	 
  private DbConfiguration dbConfiguration;
  
  @Autowired
  public HibernateConf(DbConfiguration dbConfiguration) {
    this.dbConfiguration = dbConfiguration;
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dbConfiguration.getDatasource());
      sessionFactory.setAnnotatedClasses(new Class<?>[]{com.futurebim.core.model.Company.class});
      sessionFactory.setPackagesToScan("com.futurebim.core.dao.impl");
      sessionFactory.setHibernateProperties(hibernateProperties());

      return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(dbConfiguration.getClassName());
    ds.setUrl(dbConfiguration.getJdbcUrl());
    ds.setUsername(dbConfiguration.getDbUserName());
    ds.setPassword(dbConfiguration.getPassword());
      
    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(sessionFactory().getObject());
      return transactionManager;
  }

  private final Properties hibernateProperties() {
      Properties hibernateProperties = new Properties();
      hibernateProperties.setProperty("hibernate.show_sql", "true");
      hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

      return hibernateProperties;
  }
  

}
