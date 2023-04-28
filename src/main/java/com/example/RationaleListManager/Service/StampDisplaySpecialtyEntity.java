package com.example.RationaleListManager.Service;

import com.example.RationaleListManager.Repository.KS_Stamps_SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StampDisplaySpecialtyEntity {

    @Autowired
    private KS_Stamps_SpecialtyRepository specialtyRepository;

    public void addOrDisableSpecialty(Long rationaleId, String specialtyCode, boolean enabled) {
        validateRationaleId(rationaleId);
        validateSpecialtyCode(specialtyCode);

        specialtyRepository.addOrDisableSpecialty(rationaleId, specialtyCode, enabled);
    }

    private void validateRationaleId(Long rationaleId) {
        if (rationaleId == null || rationaleId <= 0) {
            throw new IllegalArgumentException("Invalid rationale ID: " + rationaleId);
        }
    }


    private void validateSpecialtyCode(String specialtyCode) {
        if (specialtyCode == null || specialtyCode.isEmpty()) {
            throw new IllegalArgumentException("Specialty code cannot be null or empty.");
        }

        // Validate that specialty code is one of the allowed values
        List<String> allowedSpecialties = Arrays.asList("Specialty 1", "Specialty 2", "Specialty 3");
        if (!allowedSpecialties.contains(specialtyCode)) {
            throw new IllegalArgumentException("Specialty code is not one of the allowed values.");
        }
    }

}