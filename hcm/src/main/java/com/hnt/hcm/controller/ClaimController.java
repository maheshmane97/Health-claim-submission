package com.hnt.hcm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.hcm.entity.Claim;
import com.hnt.hcm.serviceImpl.ClaimServiceImpl;

@RestController
@RequestMapping("/hcm")
public class ClaimController {
	@Autowired
	ClaimServiceImpl claimServiceImpl;
	
	@PostMapping("/claim")
	public ResponseEntity<?> submitClaim(@Valid @RequestBody Claim claim, @RequestParam Integer memberId){
		Claim claim2=claimServiceImpl.submitClaim(claim, memberId);
		ResponseEntity<?> response=null;
		if(claim2!=null) {
			response=new ResponseEntity<>(claim2, HttpStatus.OK);
		}else {
			response=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}