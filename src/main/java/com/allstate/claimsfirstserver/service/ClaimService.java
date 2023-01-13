package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;

import java.util.List;

public interface ClaimService {

   public List<Claim> getAllClaims();
   public Claim getById(Integer id) throws ClaimNotFoundException;
}
