package com.cognizant.orm.learn.service;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm.learn.exception.CountryNotFoundException;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) {

        return countryRepository.findById(countryCode)
                .orElseThrow(() -> new CountryNotFoundException(countryCode));
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(String countryCode, Country updatedCountry) {

        Country existingCountry = findCountryByCode(countryCode);

        existingCountry.setName(updatedCountry.getName());

        return countryRepository.save(existingCountry);
    }
    @Transactional
    public void deleteCountry(String countryCode) {

        Country country = findCountryByCode(countryCode);

        countryRepository.delete(country);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountries(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesStartingWith(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}