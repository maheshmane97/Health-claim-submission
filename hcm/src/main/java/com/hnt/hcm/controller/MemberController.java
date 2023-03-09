package com.hnt.hcm.controller;

import com.hnt.hcm.entity.Member;
import com.hnt.hcm.serviceImpl.MemberServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/hcm")
public class MemberController {
    @Autowired
    MemberServiceImpl memberServiceImpl;

    @PostMapping
    public ResponseEntity<?> addMember(@Valid @RequestBody Member member) {
        Member member1 = memberServiceImpl.addMember(member);
        ResponseEntity<Member> response = null;
        if (member1 != null) {
            response = new ResponseEntity<>(member1, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/members")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> list = memberServiceImpl.getAllMembers();
        ResponseEntity<List<Member>> response;
        if (list != null) {
            response = new ResponseEntity<List<Member>>(list, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return response;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> findMember(@RequestParam String firstName, @RequestParam String lastName,
                                                   @RequestParam String physicianName, @RequestParam Integer claimId) {
        List<Member> list = memberServiceImpl.getMember(firstName, lastName, physicianName, claimId);
        ResponseEntity<List<Member>> response = null;
        if (!list.isEmpty()) {
            response = new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
