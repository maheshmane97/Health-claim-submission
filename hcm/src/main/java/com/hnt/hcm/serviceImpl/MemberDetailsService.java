package com.hnt.hcm.serviceImpl;

import com.hnt.hcm.configuration.MemberInfoUserDetails;
import com.hnt.hcm.entity.Member;
import com.hnt.hcm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    //member return Member object, but we Want to return UserDetails object, so we need to create MemberInfoUserDetails
    //class which implements UserDetails also override method in it
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member =memberRepository.findByUserName(username);
       return member.map(MemberInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found with "+username));

    }
}
