package com.highjump;

import com.highjump.webservice.WebserviceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties({WebserviceProperties.class})
public class HoteleverlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoteleverlinkApplication.class, args);
	}
}
