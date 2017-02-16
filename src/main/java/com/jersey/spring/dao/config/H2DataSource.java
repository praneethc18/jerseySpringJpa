package com.jersey.spring.dao.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Profile("h2")
@Configuration
@PropertySource(value = "classpath:app.persistence.properties", ignoreResourceNotFound = true)
public class H2DataSource {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql").build();
		return db;
	}

	// Start WebServer, access http://localhost:8083
	@Bean
	public Server startDBManager() throws SQLException {
		return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083");
	}
}
