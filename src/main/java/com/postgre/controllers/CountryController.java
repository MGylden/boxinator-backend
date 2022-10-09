package com.postgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgre.models.Country;
import com.postgre.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<Country> getCountry() {
		return countryService.getAllCountries();
	}

	@PostMapping
	public ResponseEntity<Country> createCountry(@RequestBody Country newCountry){
		return countryService.createCountry(newCountry);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable(value="id")Long id){
		return countryService.deleteCountry(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Country>updateCountry(@PathVariable(value="id")Long id, @Validated @RequestBody Country newCountry){
		return countryService.updateCountry(newCountry, id);
	}
}
