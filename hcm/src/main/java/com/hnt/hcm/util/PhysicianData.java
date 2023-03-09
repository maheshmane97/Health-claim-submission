package com.hnt.hcm.util;

import com.hnt.hcm.entity.Physician;
import com.hnt.hcm.repository.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Configuration
public class PhysicianData {

    @Autowired
    PhysicianRepository repository;
    @Bean
    public void savePhysicians(){
        Physician p1=new Physician(1,"Vikas Bairagi","MH","true");
        Physician p2=new Physician(2,"Sachin Patil","KA","true");
        Physician p3=new Physician(3,"Omkar Chavan","GJ","true");
        Physician p4=new Physician(4,"Rushikesh Patil","CH","true");
        Physician p5=new Physician(5,"Pratima Waghmare","MP","true");
        Physician p6=new Physician(6,"Rohit More","DL","true");
        Physician p7=new Physician(7,"Sagar Shinde","UP","true");
        Physician p8=new Physician(8,"Kedar Chavan","KE","true");

        List<Physician> list= Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8);
        repository.saveAll(list);

    }
}
