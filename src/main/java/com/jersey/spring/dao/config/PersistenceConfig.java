package com.jersey.spring.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// @PropertySource("classpath:dev.application.properties")
@EnableTransactionManagement
public class PersistenceConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasourceOracle());
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(properties());
		em.setPersistenceUnitName("JPA_PU_ORACLE");
		em.setPackagesToScan("com.jersey.spring.model.entity");

		return em;
	}

	// Oracle
	@Bean
	public DataSource datasourceOracle() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dm.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:EPS");
		dm.setUsername("EPS");
		dm.setPassword("EPS");
		return dm;
	}

	// MYSQL
	@Bean
	public DataSource datasourceMysql() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dm.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:EPS");
		dm.setUsername("EPS");
		dm.setPassword("EPS");
		return dm;
	}

	/*
	 * // -- For WAS --
	 * 
	 * @Bean public PlatformTransactionManager transactionManager() { return new
	 * WebSphereUowTransactionManager(); }
	 */

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

	// Oracle
	public Properties properties() {

		Properties properties = new Properties();

		/*
		 * // -- For WAS --
		 * //properties.setProperty("hibernate.transaction.jta.platform",
		 * "org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform"
		 * ); //properties.setProperty("hibernate.transaction.jta.platform",
		 * "org.hibernate.service.jta.platform.internal.WebSphereExtendedJtaPlatform"
		 * );
		 * 
		 * // -- For DB2 -- //properties.setProperty("hibernate.dialect",
		 * "com.lca.eps.persistence.dialect.DB2ZOSDialect");
		 */

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		properties.setProperty("hibernate.default_schema", "EPS");
		properties.setProperty("hibernate.jdbc.batch_size", "500");
		properties.setProperty("hibernate.cache.use_second_level_cache", "false");
		properties.setProperty("hibernate.id.new_generator_mappings", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.show_sql", "true");

		return properties;
	}
}
