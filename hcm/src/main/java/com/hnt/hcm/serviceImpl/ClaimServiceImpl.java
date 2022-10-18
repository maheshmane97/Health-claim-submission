package com.hnt.hcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.hcm.entity.Claim;
import com.hnt.hcm.entity.Member;
import com.hnt.hcm.repository.ClaimRepository;
import com.hnt.hcm.repository.MemberRepository;
import com.hnt.hcm.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimRepository claimRepo;
	
	@Autowired
	MemberRepository memberRepo;

	@Override
	public Claim submitClaim(Claim claim, Integer memberId) {
		Member member=memberRepo.findById(memberId).get();
		claim.setMember(member);
		Claim claim2=claimRepo.save(claim);
		return claim2;
	}






	


}
