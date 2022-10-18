package com.hnt.hcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.hcm.entity.Physician;
import com.hnt.hcm.repository.PhysicianRepository;
import com.hnt.hcm.service.PhysicianService;

@Service
public class PhysicianServiceImpl implements PhysicianService {
	@Autowired
	PhysicianRepository physicianRepository;
	
	@Override
	public Physician addPhysician(Physician physician) {
		return physicianRepository.save(physician);
	}

}
