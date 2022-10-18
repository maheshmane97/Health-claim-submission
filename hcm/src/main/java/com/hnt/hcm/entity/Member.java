package com.hnt.hcm.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "FirstName should not be blank###")
	@Length(min = 5, max = 50)
	private String firstName;

	@NotBlank(message = "LastName should not be blank###")
	@Length(min = 5, max = 50)
	private String lastName;

	@NotBlank(message = "UserName should not be blank###")
	@Size(min = 5, max = 12, message = "UserName inbetween 5 to 12 characters")
	private String userName;

	@NotBlank(message = "Address should not be blank###")
	@Length(max = 100, message = "Address can upto 100 characters")
	private String address;

	@NotBlank(message = "State Name should not be blank###")
	private String state;

	@NotBlank(message = "City Name should not be blank###")
	private String city;

	@Email(message = "Please enter valid Email Id###")
	private String emailId;

	
	private String dob;

	@OneToOne
	private Claim claims;

	@OneToOne
	private Physician physician;

	
	
	
	
	
	
	
	
	
	
	
}
