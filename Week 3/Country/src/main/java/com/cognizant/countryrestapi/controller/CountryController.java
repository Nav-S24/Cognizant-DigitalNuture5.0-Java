package com.cognizant.countryrestapi.controller;

import com.cognizant.countryrestapi.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.countryrestapi.service.CountryService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class CountryController {
    private final CountryService countryService;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        LOGGER.debug("Countries: {}", countries);
        LOGGER.info("END");

        return countries;
    }
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        LOGGER.info("START");
        LOGGER.debug("Country code: {}", code);

        Country country = countryService.getCountry(code);

        LOGGER.info("END");

        return country;
    }
    @PostMapping("/countries")
    public Country addCountry(@Valid @RequestBody Country country) {

        LOGGER.info("START");
        LOGGER.debug("Country received: {}", country);

        LOGGER.info("END");

        return country;
    }

}