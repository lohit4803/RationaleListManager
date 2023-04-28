package com.example.RationaleListManager.Repository;

import com.example.RationaleListManager.Models.StampCPTFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KS_Stamps_CPTRepository extends JpaRepository<StampCPTFilterEntity, Long> {
    void addOrUpdateCptCodes(Long rationaleId, List<String> individualCodes, List<String> rangeCodes);
}
