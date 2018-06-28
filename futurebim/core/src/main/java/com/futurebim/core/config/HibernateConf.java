package com.futurebim.core.config;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConf {

  private final DbConfiguration dbConfiguration;

  @Autowired
  public HibernateConf(final DbConfiguration dbConfiguration) {
    this.dbConfiguration = dbConfiguration;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {

    final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dbConfiguration.getDatasource());

    sessionFactory.setAnnotatedClasses(findAllEntities());
    sessionFactory.setPackagesToScan("com.futurebim.core.dao.impl");
    sessionFactory.setHibernateProperties(hibernateProperties());

    return sessionFactory;
  }

  private Class<?>[] findAllEntities() {
    final ArrayList<Class> classes = new ArrayList<>();

    final ClassPathScanningCandidateComponentProvider scanner =
                                                              new ClassPathScanningCandidateComponentProvider(false);
    scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
    scanner.addIncludeFilter(new AnnotationTypeFilter(Table.class));

    Set<BeanDefinition> bdlist = scanner.findCandidateComponents("com.futurebim.core.model");

    for (final BeanDefinition bd : bdlist) {
      final String name = bd.getBeanClassName();
      try {
        classes.add(Class.forName(name));
      }
      catch (final Exception E) {
      }
    }

    bdlist = scanner.findCandidateComponents("com.futurebim.core.model.ifc");
    for (final BeanDefinition bd : bdlist) {
      final String name = bd.getBeanClassName();
      try {
        classes.add(Class.forName(name));
      }
      catch (final Exception E) {
      }
    }

    return classes.toArray(new Class[classes.size()]);
  }

  @Bean
  public DataSource dataSource() {
    final BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(dbConfiguration.getClassName());
    ds.setUrl(dbConfiguration.getJdbcUrl());
    ds.setUsername(dbConfiguration.getDbUserName());
    ds.setPassword(dbConfiguration.getPassword());

    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

  private final Properties hibernateProperties() {
    final Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

    return hibernateProperties;
  }

}
