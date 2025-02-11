package com.milan.sample_backend_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SampleBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleBackendApiApplication.class, args);
	}

}
