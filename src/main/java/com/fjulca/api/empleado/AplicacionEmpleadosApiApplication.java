package com.fjulca.api.empleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.**.security,com.**.controller", "com.**.service" ,"com.**.service.impl", "com.**.repository"})
@EnableJpaRepositories(basePackages={"com.**.security,com.**.controller", "com.**.service" ,"com.**.service.impl", "com.**.repository"})
@EnableTransactionManagement
public class AplicacionEmpleadosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionEmpleadosApiApplication.class, args);
	}

	
}
