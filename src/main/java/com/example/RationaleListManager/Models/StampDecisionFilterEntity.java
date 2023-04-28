package com.example.RationaleListManager.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "KS_Stamps_Decision")
public class StampDecisionFilterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampDecisionFilterID;

    @ManyToOne
    @JoinColumn(name = "StampComputingID", nullable = false)
    private StampComputingEntity stampComputing;

    @Column(name = "DecisionText", nullable = false)
    private String decisionText;

}