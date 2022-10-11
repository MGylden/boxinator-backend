package com.postgre.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgre.demo.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public boolean existByMail();
}
