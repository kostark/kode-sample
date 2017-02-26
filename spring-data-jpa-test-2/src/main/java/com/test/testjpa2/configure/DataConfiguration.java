package com.test.testjpa2.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * @since 1.0 - 2017/2/20
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class DataConfiguration {

//	@Autowired
//	private JpaProperties jpaProperties;

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

//	@Bean
//	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//		return entityManagerFactory(builder).getObject().createEntityManager();
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
//		return builder
//				.dataSource(dataSource())
//				.properties(getVendorProperties(primaryDS))
//				.packages("com.anxpp.web.core.entity.po") //设置实体类所在位置
//				.persistenceUnit("primaryPersistenceUnit")
//				.build();
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactory =
//				new LocalContainerEntityManagerFactoryBean();
//
//		entityManagerFactory.setDataSource(dataSource());
//
//		// Classpath scanning of @Component, @Service, etc annotated class
//		entityManagerFactory.setPackagesToScan(
//				env.getProperty("entitymanager.packagesToScan"));
//
//		// Vendor adapter
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//		// Hibernate properties
//		Properties additionalProperties = new Properties();
//		additionalProperties.put(
//				"hibernate.dialect",
//				env.getProperty("hibernate.dialect"));
//		additionalProperties.put(
//				"hibernate.show_sql",
//				env.getProperty("hibernate.show_sql"));
//		additionalProperties.put(
//				"hibernate.hbm2ddl.auto",
//				env.getProperty("hibernate.hbm2ddl.auto"));
//		entityManagerFactory.setJpaProperties(additionalProperties);
//
//		return entityManagerFactory;
//	}
//
//	private Map<String, String> getVendorProperties(DataSource dataSource) {
//		return jpaProperties.getHibernateProperties(dataSource);
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
//	}
}
