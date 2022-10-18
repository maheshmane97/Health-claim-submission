package com.hnt.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.hcm.entity.Physician;
import com.hnt.hcm.serviceImpl.PhysicianServiceImpl;

@RestController
@RequestMapping("/hcm")
public class PhysicianController {
	@Autowired
	PhysicianServiceImpl physicianServiceImpl;
	
	@PostMapping("/physician")
	public Physician addPhysician(@RequestBody Physician physician) {
		return physicianServiceImpl.addPhysician(physician);
	}
}
