package com.example.demo;

import com.cognizant.demo.service.CountryService;
import com.cognizant.demo.model.Country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    
    private static CountryService countryService;

    public static void main(String[] args) {
        
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        
        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries = {}", countries);

        LOGGER.info("End");
    }
}


