package com.allstate.claimsfirstserver.data;

import com.allstate.claimsfirstserver.domain.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

   public List<Claim> findAllByInsuranceType(String insuranceType);

   public List<Claim> findAllByStatus(String status);

}
