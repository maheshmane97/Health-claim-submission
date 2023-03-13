package com.hnt.hcm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSearchRequest {

    private String firstName;
    private String lastName;
    private Integer memberId;
    private Integer claimId;
    private String physicianName;
}
