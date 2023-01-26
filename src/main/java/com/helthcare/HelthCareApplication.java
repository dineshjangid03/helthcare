package com.helthcare;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HelthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelthCareApplication.class, args);
	}
	
	@Bean
    Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(apiDetails());
    }
	
	public ApiInfo apiDetails() {
		return new ApiInfo(
				"HelthCare API",
				"Sample API For HelthCare where doctors can register their patients through a mobile or web portal",
				"pm",
				"Free to use",
				new springfox.documentation.service.Contact("HelthCare Team", "HelthCare.demo", "HelthCare@demo.com"),
				"API license",
				"http://HelthCare.io",
				Collections.emptyList()
				);
		
	}

}
