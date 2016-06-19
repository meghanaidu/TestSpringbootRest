package com.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author megha
 *
 */
@SpringBootApplication
public class ContactsProcessingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ContactsProcessingApplication.class, args);
	}

	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(ContactsProcessingApplication.class);
	}
}
