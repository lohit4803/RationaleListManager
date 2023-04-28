package com.example.RationaleListManager.Repository;

import com.example.RationaleListManager.Models.StampDisplaySpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KS_Stamps_SpecialtyRepository extends JpaRepository<StampDisplaySpecialtyEntity,Long> {

    void addOrDisableSpecialty(Long rationaleId, String specialtyCode, boolean enabled);

}
