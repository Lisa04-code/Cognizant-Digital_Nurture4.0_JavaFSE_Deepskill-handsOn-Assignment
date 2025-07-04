package com.cognizant.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.demo.model.Country;


public interface CountryRepository extends JpaRepository<Country, String> { }

