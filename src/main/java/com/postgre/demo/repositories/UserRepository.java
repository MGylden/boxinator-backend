package com.postgre.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.postgre.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existByMail(String userEmail);
}
