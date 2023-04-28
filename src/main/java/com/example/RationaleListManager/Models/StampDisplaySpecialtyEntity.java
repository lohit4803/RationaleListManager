package com.example.RationaleListManager.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "KS_Stamps_Specialty")
public class StampDisplaySpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampDisplaySpecialtyID;

    @ManyToOne
    @JoinColumn(name = "StampComputingID", nullable = false)
    private StampComputingEntity stampComputing;

    @Column(name = "SpecialtyCode", nullable = false)
    private String specialtyCode;

    @Column(name = "Enable")
    private boolean enable;

}