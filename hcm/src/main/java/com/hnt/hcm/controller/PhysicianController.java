package com.hnt.hcm.controller;

import com.hnt.hcm.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hnt.hcm.entity.Physician;
import com.hnt.hcm.serviceImpl.PhysicianServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/hcm")
public class PhysicianController {
	@Autowired
	PhysicianServiceImpl physicianServiceImpl;

	@Autowired
	PhysicianRepository repository;
	
	@PostMapping("/physician")
	public Physician addPhysician(@RequestBody Physician physician) {
		return physicianServiceImpl.addPhysician(physician);
	}

	@GetMapping("/ph")
	@PreAuthorize("hasAuthority('ROLE_MEMBER')")
	public List<Physician> getAll(){
		return repository.findAll();
	}
}
