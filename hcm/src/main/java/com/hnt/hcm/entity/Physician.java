package com.hnt.hcm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class Physician {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer physicianId;
	
	private String physicianName;
	
	private String physicianState;
	
	private String status;
	
	@OneToOne
	private Member member;
	
}
