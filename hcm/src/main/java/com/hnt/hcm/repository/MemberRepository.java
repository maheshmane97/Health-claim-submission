package com.hnt.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hnt.hcm.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByUserName(String username);
}
