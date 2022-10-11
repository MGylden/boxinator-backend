package com.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.postgre.models.Shipments;

@EnableJpaRepositories
@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Long> {

}
