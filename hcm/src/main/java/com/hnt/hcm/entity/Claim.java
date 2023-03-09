package com.hnt.hcm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer claimId;

    @Enumerated(EnumType.STRING)
    private ClaimType claimType;

    @Min(value = 100, message = "Price should be more than 100 Ruppes")
    private Double claimAmount;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date claimDate;

    @NotBlank(message = "Remarks should not be blank###")
    @Length(max = 1000, message = "Remarks can upto 1000 characters")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "claimId", nullable = false, insertable = false, updatable = false)
    private Member member;

}
