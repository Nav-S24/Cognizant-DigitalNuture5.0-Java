package com.cognizant.countryrestapi.service;

import com.cognizant.countryrestapi.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.countryrestapi.service.exception.CountryNotFoundException;
import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {

        LOGGER.info("START");
        LOGGER.debug("Country code: {}", code);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("Country found: {}", country);
                LOGGER.info("END");
                return country;
            }
        }

        LOGGER.info("Country not found");
        throw new CountryNotFoundException();
    }
}