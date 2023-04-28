package com.example.RationaleListManager.Contoller;

import com.example.RationaleListManager.Service.StampDecisionFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decision")
public class StampDecisionFilterController {

    @Autowired
    private StampDecisionFilterService decisionFilterService;

    @PostMapping("/{rationaleId}")
    public ResponseEntity<String> addOrUpdateDecision(@PathVariable Long rationaleId, @RequestBody String decisionText) {
        try {
            decisionFilterService.addOrUpdateDecision(rationaleId, decisionText);
            return new ResponseEntity<>("Decision added/updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add/update decision", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
