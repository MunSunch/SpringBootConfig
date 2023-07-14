package com.munsun.configuration_spring_boot._app;

import com.munsun.configuration_spring_boot.profile.config.ProfileConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.munsun.configuration_spring_boot.controllers",
					   scanBasePackageClasses = ProfileConfiguration.class)
public class ConfigurationSpringBootAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationSpringBootAppApplication.class, args);
	}
}
