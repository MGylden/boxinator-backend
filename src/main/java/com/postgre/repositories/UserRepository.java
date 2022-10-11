package com.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream:src/main/java/com/postgre/repositories/UserRepository.java
=======
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
>>>>>>> Stashed changes:src/main/java/com/postgre/demo/repositories/UserRepository.java
import org.springframework.stereotype.Repository;

import com.postgre.models.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

<<<<<<< Updated upstream:src/main/java/com/postgre/repositories/UserRepository.java
	boolean existByMail();
=======
>>>>>>> Stashed changes:src/main/java/com/postgre/demo/repositories/UserRepository.java
}
