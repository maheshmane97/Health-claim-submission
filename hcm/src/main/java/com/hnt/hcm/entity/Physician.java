package com.hnt.hcm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Physician {
    @Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer physicianId;

    private String physicianName;

    private String physicianState;

    private String status;

    @OneToOne
    private Member member;

    public Physician(Integer physicianId, String physicianName, String physicianState, String status) {
        this.physicianId = physicianId;
        this.physicianName = physicianName;
        this.physicianState = physicianState;
        this.status = status;
    }
}
