package com.example.RationaleListManager.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "KS_Stamps_Computing")
public class StampComputingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampComputingID;

    @Column(name = "StampText")
    private String stampText;

    @Column(name = "RationaleID")
    private String rationaleID;

    @Column(name = "Source")
    private String source;

    @OneToMany(mappedBy = "stampComputing", cascade = CascadeType.ALL)
    private List<StampDisplaySpecialtyEntity> stampDisplaySpecialties;

    @OneToMany(mappedBy = "stampComputing", cascade = CascadeType.ALL)
    private List<StampDecisionFilterEntity> stampDecisionFilters;

    @OneToMany(mappedBy = "stampComputing", cascade = CascadeType.ALL)
    private List<StampCPTFilterEntity> stampCPTFilters;

    @OneToMany(mappedBy = "stampComputing", cascade = CascadeType.ALL)
    private List<StampModifierFilterEntity> stampModifierFilters;

}