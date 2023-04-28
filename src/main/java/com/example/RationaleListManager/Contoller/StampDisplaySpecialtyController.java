package com.example.RationaleListManager.Contoller;

import com.example.RationaleListManager.Service.StampDisplaySpecialtyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialty")
public class StampDisplaySpecialtyController {

    @Autowired
    private StampDisplaySpecialtyEntity specialtyEntity;

    @PostMapping("/{rationaleId}")
    public ResponseEntity<String> addOrDisableSpecialty(@PathVariable Long rationaleId, @RequestBody SpecialtyRequest request) {
        try {
            specialtyEntity.addOrDisableSpecialty(rationaleId, request.getSpecialtyCode(), request.isEnabled());
            return new ResponseEntity<>("Specialty added/disabled successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add/disable specialty", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    static class SpecialtyRequest {
        private String specialtyCode;
        private boolean enabled;

        public String getSpecialtyCode() {
            return specialtyCode;
        }

        public void setSpecialtyCode(String specialtyCode) {
            this.specialtyCode = specialtyCode;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
