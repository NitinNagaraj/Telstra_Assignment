package com.hcl.telstraAssignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * configuration class for Swagger documentation
 * 
 * @author Nithin N
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENSE_TEXT = "Apache License Version 2.0";
	private static final String TITLE = "Spring Boot REST API";
	private static final String DESCRIPTION = "Spring Boot REST API for Fibonacci series, Reverse word, Triangle type and Make one array";
	private static final String CONTACT = "Nithin.N@hcl.com";

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).license(LICENSE_TEXT)
				.version(SWAGGER_API_VERSION).contact(CONTACT).build();
	}

	@Bean
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.hcl.telstraAssignment")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}
}
