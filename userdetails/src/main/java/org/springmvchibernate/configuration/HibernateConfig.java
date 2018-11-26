package org.springmvchibernate.configuration;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dell
 *
 */
@Configuration
@PropertySource("classpath:configuration.properties")
@EnableTransactionManagement
@ComponentScans(value = { 
      @ComponentScan("org.springmvchibernate") 
    })
public class HibernateConfig {
	
   @Value("${db.driverClassName}")     private String driverClassName;
   @Value("${db.url}")                 private String url;
   @Value("${db.username}")            private String username;
   @Value("${db.password}")            private String password;   
   @Value("${hibernate.dialect}")      private String hibernateDialect;
   @Value("${hibernate.show_sql}")     private String hibernateShowSql;
   @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
    
   @Bean
   public DataSource getDataSource() {
     final BasicDataSource dataSource = new BasicDataSource();
    //final DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(driverClassName);
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      return dataSource;
   }
   
   @Bean
   public Properties getHibernateProperties(){
      final Properties properties = new Properties();
       properties.put("hibernate.dialect", hibernateDialect);
       properties.put("hibernate.show_sql", hibernateShowSql);
       properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
       
       return properties;
   }
   /* ---------------------------------------------------------------------------------------------------------------------- */
   /* ---------------------------------------------------------------------------------------------------------------------- */
   
   										/* 	Entitymanager Jpa Configutration	*/
   @Bean
   public LocalContainerEntityManagerFactoryBean geEntityManagerFactoryBean() {
     final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
      entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
 /*	  entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());		*/
      entityManagerFactoryBean.setDataSource(getDataSource());
      entityManagerFactoryBean.setPackagesToScan(new String[] {"org.springmvchibernate"});
      entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
     
      return entityManagerFactoryBean;
   } 
   
   @Bean
   public JpaTransactionManager geJpaTransactionManager() {
     final JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
      return transactionManager;
   }
   /* ---------------------------------------------------------------------------------------------------------------------- */
   
}
