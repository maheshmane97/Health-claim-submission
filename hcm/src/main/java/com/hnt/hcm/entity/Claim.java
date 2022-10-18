package com.hnt.hcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	@OneToOne
	@JsonIgnore
	private Member member;
	
}
