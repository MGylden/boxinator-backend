package com.postgre.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgre.demo.models.Shipments;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Long> {
}
