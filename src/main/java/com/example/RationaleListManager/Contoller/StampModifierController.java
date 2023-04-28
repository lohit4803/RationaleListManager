package com.example.RationaleListManager.Contoller;

import com.example.RationaleListManager.Service.StampModifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modifier")
public class StampModifierController {

    @Autowired
    private StampModifierService modifierService;

    @PostMapping("/{rationaleId}")
    public ResponseEntity<String> addOrUpdateModifiers(@PathVariable Long rationaleId, @RequestBody List<String> modifiers) {
        try {
            modifierService.addOrUpdateModifiers(rationaleId, modifiers);
            return new ResponseEntity<>("Modifiers added/updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add/update modifiers", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
