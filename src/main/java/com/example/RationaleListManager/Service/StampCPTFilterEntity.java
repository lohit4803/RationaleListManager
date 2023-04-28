package com.example.RationaleListManager.Service;

import com.example.RationaleListManager.Repository.KS_Stamps_CPTRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StampCPTFilterEntity {
    private final KS_Stamps_CPTRepository cptCodeRepository;

    public StampCPTFilterEntity(KS_Stamps_CPTRepository cptCodeRepository) {
        this.cptCodeRepository = cptCodeRepository;
    }

    public void addOrUpdateCptCodes(Long rationaleId, List<String> individualCodes, List<String> rangeCodes) {
        validateRationaleId(rationaleId);

        if (individualCodes != null && !individualCodes.isEmpty()) {
            for (String code : individualCodes) {
                validateCptCode(code);
            }
        }

        if (rangeCodes != null && !rangeCodes.isEmpty()) {
            for (String range : rangeCodes) {
                validateCptCodeRange(range);
            }
        }

        cptCodeRepository.addOrUpdateCptCodes(rationaleId, individualCodes, rangeCodes);
    }

    private void validateCptCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("CPT code cannot be null or empty.");
        }

    }

    private void validateCptCodeRange(String range) {
        if (range == null || range.isEmpty()) {
            throw new IllegalArgumentException("CPT code range cannot be null or empty.");
        }

    }

    private void validateRationaleId(Long rationaleId) {
        if (rationaleId == null) {
            throw new IllegalArgumentException("Rationale ID cannot be null.");
        }
    }
}
