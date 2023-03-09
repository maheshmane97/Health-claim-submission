package com.hnt.hcm.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;


import java.util.List;

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
    @Size(min = 5, max = 12, message = "UserName in between 5 to 12 characters")
    private String userName;

    @NotBlank(message = "Password should not be blank###")
    @Size(min = 8, max = 12, message = "Password in between 5 to 12 characters")
    private String password;

    @NotBlank(message = "Address should not be blank###")
    @Length(max = 100, message = "Address can up to 100 characters")
    private String address;

    @NotBlank(message = "State Name should not be blank###")
    private String state;

    @NotBlank(message = "City Name should not be blank###")
    private String city;

    @Email(message = "Please enter valid Email Id###")
    private String emailId;

    @NotBlank
    private String roles;
    private String dob;

    @OneToMany(mappedBy = "member")
    private List<Claim> claims;

    @OneToOne
    private Physician physician;


}
