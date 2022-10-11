package com.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream:src/main/java/com/postgre/repositories/CountryRepository.java
=======
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
>>>>>>> Stashed changes:src/main/java/com/postgre/demo/repositories/CountryRepository.java

import com.postgre.models.Country;

<<<<<<< Updated upstream:src/main/java/com/postgre/repositories/CountryRepository.java
=======
@EnableJpaRepositories
@Repository
>>>>>>> Stashed changes:src/main/java/com/postgre/demo/repositories/CountryRepository.java
public interface CountryRepository extends JpaRepository<Country, Long> {

	public boolean existByMail();
}
