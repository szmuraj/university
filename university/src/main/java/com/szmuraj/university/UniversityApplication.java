package com.szmuraj.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Bean
	public Docket get() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.build()
				.apiInfo(createApiInfo());
	}

	private ApiInfo createApiInfo() {
		return new ApiInfo(
				"University API",
				"University database",
				"1.00",
				"termsOfServiceUrl",
				new Contact("Przemek", "url", "przemyslaw.sicinski@o2.pl"),
				"licence",
				"licenceUrl",
				Collections.emptyList()
		);
	}

}
