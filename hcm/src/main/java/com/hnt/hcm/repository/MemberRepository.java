package com.hnt.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.hcm.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
