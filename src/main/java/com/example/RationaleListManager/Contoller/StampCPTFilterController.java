package com.example.RationaleListManager.Contoller;

import com.example.RationaleListManager.Service.StampCPTFilterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpt-filter")
public class StampCPTFilterController {
    private final StampCPTFilterEntity stampCPTFilterEntity;

    @Autowired
    public StampCPTFilterController(StampCPTFilterEntity stampCPTFilterEntity) {
        this.stampCPTFilterEntity = stampCPTFilterEntity;
    }

    @PostMapping("/{rationaleId}")
    public ResponseEntity<String> addOrUpdateCptCodes(@PathVariable Long rationaleId,
                                                      @RequestBody CptCodeRequestDto requestDto) {
        stampCPTFilterEntity.addOrUpdateCptCodes(rationaleId, requestDto.getIndividualCodes(),
                requestDto.getRangeCodes());
        return ResponseEntity.status(HttpStatus.OK).body("CPT codes added or updated successfully");
    }

    static class CptCodeRequestDto {
        private List<String> individualCodes;
        private List<String> rangeCodes;

        public List<String> getIndividualCodes() {
            return individualCodes;
        }

        public void setIndividualCodes(List<String> individualCodes) {
            this.individualCodes = individualCodes;
        }

        public List<String> getRangeCodes() {
            return rangeCodes;
        }

        public void setRangeCodes(List<String> rangeCodes) {
            this.rangeCodes = rangeCodes;
        }
    }
}
