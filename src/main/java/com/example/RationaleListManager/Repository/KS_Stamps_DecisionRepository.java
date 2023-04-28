package com.example.RationaleListManager.Repository;

import com.example.RationaleListManager.Models.StampDecisionFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KS_Stamps_DecisionRepository extends JpaRepository<StampDecisionFilterEntity,Long> {

    void addOrUpdateDecision(Long rationaleId, String decisionText);

}
