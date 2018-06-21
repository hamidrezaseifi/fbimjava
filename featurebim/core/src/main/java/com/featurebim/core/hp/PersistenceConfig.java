package com.featurebim.core.hp;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
	 
	   @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(restDataSource());
	      sessionFactory.setPackagesToScan(
	        new String[] { "org.baeldung.spring.persistence.model" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	 
	      return sessionFactory;
	   }
	 
	   @Bean
	   public DataSource restDataSource() {
		   final HikariConfig configuration = new HikariConfig();
	 
		   configuration.setAutoCommit(false);
		    configuration.setPoolName("FBIM-DB-POOL");
		    configuration.setDriverClassName("com.mysql.jdbc.Driver");
		    configuration.setMinimumIdle(5);
		    configuration.setJdbcUrl("jdbc:mysql://localhost:3306/featurebim");
		    configuration.setIdleTimeout(120000L);
		    configuration.setMaximumPoolSize(50);
		    configuration.setUsername("bim");
		    configuration.setPassword("bim");
		    configuration.setTransactionIsolation("TRANSACTION_READ_COMMITTED");
		    
		    final HikariDataSource ds = new HikariDataSource(configuration);
		    ds.validate();
		    return ds;
	   }
	 
	   @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(
	     SessionFactory sessionFactory) {
	  
	      HibernateTransactionManager txManager
	       = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	 
	      return txManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties hibernateProperties() {
	      return new Properties() {
	         {
	            setProperty("hibernate.hbm2ddl.auto",
	              "create-drop");
	            setProperty("hibernate.dialect",
	              "org.hibernate.dialect.MySQL5Dialect");
	            setProperty("hibernate.globally_quoted_identifiers",
	             "true");
	         }
	      };
	   }
}
