package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;

import java.util.List;

public interface ClaimService {

   public List<Claim> getAllClaims();
   public Claim getById(Integer id) throws ClaimNotFoundException;

   public List<Claim> getByInsuranceType(String insuranceType);

   public List<Claim> getByStatus(String status);

   public List<Claim> getByPolicyNumber(String policyNumber);

   public List<String> getAllInsuranceTypes();
}
