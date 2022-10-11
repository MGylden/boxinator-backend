package com.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.postgre.models.Country;

@EnableJpaRepositories
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
