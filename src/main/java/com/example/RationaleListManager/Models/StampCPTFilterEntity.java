package com.example.RationaleListManager.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "KS_Stamps_CPT")
public class StampCPTFilterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampCPTFilterID;

    @ManyToOne
    @JoinColumn(name = "StampComputingID", nullable = false)
    private StampComputingEntity stampComputing;

    @Column(name = "ServiceCodeList")
    private String serviceCodeList;

    @Column(name = "ServiceCodeFrom")
    private String serviceCodeFrom;

    @Column(name = "ServiceCodeTo")
    private String serviceCodeTo;

}