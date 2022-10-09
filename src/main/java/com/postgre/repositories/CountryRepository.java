package com.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgre.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	public boolean existByMail();
}
