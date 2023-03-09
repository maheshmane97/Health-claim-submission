package com.hnt.hcm.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hnt.hcm.entity.Member;
import com.hnt.hcm.entity.Physician;
import com.hnt.hcm.repository.ClaimRepository;
import com.hnt.hcm.repository.MemberRepository;
import com.hnt.hcm.repository.PhysicianRepository;
import com.hnt.hcm.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PhysicianRepository physicianRepository;

    @Autowired
    ClaimRepository claimRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Member addMember(Member member) {
        Member mem = null;
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        if (member.getRoles().equals("ROLE_ADMIN")) {
            mem = memberRepository.save(member);
        } else {
            Iterator<Physician> itr = physicianRepository.findByStatus("false").iterator();
            if (itr.hasNext()) {
                Physician physi = itr.next();
                member.setPhysician(physi);
                physi.setStatus("true");
                mem = memberRepository.save(member);
            }
        }


        return mem;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> getMember(String firstName, String lastName, String physicianName, Integer claimId) {
        List<Member> list = memberRepository.findAll();

//		List<Member> member = list.stream()
//				.filter(e -> e.getFirstName().equalsIgnoreCase(firstName) || e.getLastName().equalsIgnoreCase(lastName)
//						|| e.getPhysician().getPhysicianName().equalsIgnoreCase(physicianName)
//						|| e.getClaims().getClaimId() == claimId)
//				.collect(Collectors.toList());

        return null;
    }

}
