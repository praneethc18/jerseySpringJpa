package com.jersey.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.jersey.spring.dao.config.PersistenceConfig;

@Configuration
@ComponentScan(basePackages = { "com.jersey.spring.service.*" })
@PropertySource("classpath:dev.application.properties")
//@ImportResource("dev.spring.xml")
@Import(PersistenceConfig.class)
public class AppSpringConfig {

}
