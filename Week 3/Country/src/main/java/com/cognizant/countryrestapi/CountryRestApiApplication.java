package com.cognizant.countryrestapi;

import com.cognizant.countryrestapi.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class CountryRestApiApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(CountryRestApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CountryRestApiApplication.class, args);

		displayCountries();
	}

	public static void displayCountries() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries =
				context.getBean("countryList", List.class);

		LOGGER.debug("Countries: {}", countries);

		LOGGER.info("END");
	}
}