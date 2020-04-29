package com.cg.iter.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.Oracle10gDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.cg.iter")
@EnableJpaRepositories("com.cg.iter")
@EnableTransactionManagement
public class StudentWebMVCConfig {
	
	private static final Logger Log= LoggerFactory.getLogger(StudentWebMVCConfig.class);
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em
				= new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(oracleDataSource());
		em.setPackagesToScan("com.cg.iter");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(oracleProperties());
		return em;
	}
	@Bean
	public DataSource oracleDataSource() {
		try {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUser("iter");
			dataSource.setPassword("iter123");
			return dataSource;
		} catch (Throwable e) {
			Log.error("exception in OracleDataSource()",e);
			return null;
		}
	}

      Properties oracleProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", Oracle10gDialect.class.getName());
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
		return properties;
	}
      
  	@Bean
  	public PlatformTransactionManager transactionManager(
  			EntityManagerFactory emf) {
  		JpaTransactionManager transactionManager = new JpaTransactionManager();
  		transactionManager.setEntityManagerFactory(emf);
  		return transactionManager;
  	}

  	@Bean
  	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
  		return new PersistenceExceptionTranslationPostProcessor();
  	}



	
}
