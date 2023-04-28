package com.example.RationaleListManager.Service;

import java.util.List;

public class StampModifierService {

    public void addOrUpdateModifiers(Long rationaleId, List<String> modifiers) {
        validateRationaleId(rationaleId);
}

    private void validateRationaleId(Long rationaleId) {
        if (rationaleId == null) {
            throw new IllegalArgumentException("Rationale ID cannot be null.");
        }
    }
}
