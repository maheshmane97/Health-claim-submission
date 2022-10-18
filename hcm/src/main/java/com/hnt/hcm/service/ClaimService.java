package com.hnt.hcm.service;

import com.hnt.hcm.entity.Claim;

public interface ClaimService {
	
	public Claim submitClaim(Claim claim, Integer memberId);
}
