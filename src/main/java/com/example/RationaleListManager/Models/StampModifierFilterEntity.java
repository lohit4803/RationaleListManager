package com.example.RationaleListManager.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "KS_Stamps_Modifier")
public class StampModifierFilterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampModifierFilterID;

    @ManyToOne
    @JoinColumn(name = "StampComputingID", nullable = false)
    private StampComputingEntity stampComputing;

    @Column(name = "ModifierList")
    private String modifierList;

}