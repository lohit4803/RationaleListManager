package com.example.RationaleListManager.Service;

import com.example.RationaleListManager.Repository.KS_Stamps_DecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StampDecisionFilterService {

    @Autowired
    private KS_Stamps_DecisionRepository decisionRepository;

    public void addOrUpdateDecision(Long rationaleId, String decisionText) {
        validateRationaleId(rationaleId);
        validateDecisionText(decisionText);

        decisionRepository.addOrUpdateDecision(rationaleId, decisionText);
    }

    private void validateRationaleId(Long rationaleId) {
        if (rationaleId == null) {
            throw new IllegalArgumentException("Rationale ID cannot be null.");
        }
    }

    private void validateDecisionText(String decisionText) {
        if (decisionText == null || decisionText.isEmpty()) {
            throw new IllegalArgumentException("Decision text cannot be null or empty.");
        }

        List<String> allowedDecisions = Arrays.asList("Approved", "Denied", "Inclusive Denial", "Deny and Suggest Code", "Code is payable but adjust no. of units");
        if (!allowedDecisions.contains(decisionText)) {
            throw new IllegalArgumentException("Decision text is not one of the allowed values.");
        }
    }

}

