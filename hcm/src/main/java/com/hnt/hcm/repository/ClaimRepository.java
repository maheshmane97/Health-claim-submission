package com.hnt.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.hcm.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	Claim findByClaimId(Integer claimId);
	
	Claim findByMemberId(Integer memberId);
}
