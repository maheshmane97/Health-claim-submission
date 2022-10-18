package com.hnt.hcm.service;

import java.util.List;

import com.hnt.hcm.entity.Member;

public interface MemberService {
	
	public Member addMember(Member member);
	
	public List<Member> getAllMembers();
	
	public List<Member> getMember(String firstName, String lastName, String physicianName, Integer claimId);
	
	
}
