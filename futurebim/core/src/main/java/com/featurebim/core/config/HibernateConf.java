package com.featurebim.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.featurebim.core.hp.Company;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@EnableTransactionManagement
public class HibernateConf {
	 
  private DataSource dataSource;
  
  @Autowired
  public HibernateConf(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(this.dataSource);
      sessionFactory.setAnnotatedClasses(new Class<?>[]{com.featurebim.core.hp.Company.class});
      sessionFactory.setPackagesToScan("com.featurebim.core.hp");
      sessionFactory.setHibernateProperties(hibernateProperties());

      return sessionFactory;
  }

  /*@Bean
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/featurebim");
    ds.setUsername("bim");
    ds.setPassword("bim");
    
    
    
    return ds;
  }*/

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
