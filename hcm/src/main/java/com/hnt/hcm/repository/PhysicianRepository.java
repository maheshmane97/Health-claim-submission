package com.hnt.hcm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.hcm.entity.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
	
	List<Physician> findByStatus(String status);
	
	

}
