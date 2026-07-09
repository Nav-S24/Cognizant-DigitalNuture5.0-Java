package com.cognizant.orm.learn.controller;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryService.findCountryByCode(code);
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country updateCountry(
            @PathVariable String code,
            @RequestBody Country country) {

        return countryService.updateCountry(code, country);
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> searchCountries(@RequestParam String text) {
        return countryService.searchCountries(text);
    }

    @GetMapping("/search/sorted")
    public List<Country> searchCountriesSorted(@RequestParam String text) {
        return countryService.searchCountriesSorted(text);
    }

    @GetMapping("/starts-with")
    public List<Country> findCountriesStartingWith(
            @RequestParam String letter) {

        return countryService.findCountriesStartingWith(letter);
    }
}