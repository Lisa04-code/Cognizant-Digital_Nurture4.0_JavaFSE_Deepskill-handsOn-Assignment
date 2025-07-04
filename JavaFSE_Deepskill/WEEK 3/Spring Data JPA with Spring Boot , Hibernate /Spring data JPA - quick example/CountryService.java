package com.cognizant.demo.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.demo.model.Country;
import com.cognizant.demo.repository.CountryRepository;


public class CountryService {

    
    private CountryRepository countryRepository;


    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}


