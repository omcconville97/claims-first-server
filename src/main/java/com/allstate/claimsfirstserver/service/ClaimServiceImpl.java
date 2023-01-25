package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.data.ClaimRepository;
import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims(){
        List<Claim> claims = claimRepository.findAll();
        System.out.println("There were " + claims.size() + " found");
        return claims;
    }

    @Override
    public Claim getById(Integer id) throws ClaimNotFoundException
    {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            return optionalClaim.get();
        } else {
            throw new ClaimNotFoundException("There is no claim with id " +id);
        }
    }

    @Override
    public List<Claim> getByInsuranceType(String insuranceType) {
        return claimRepository.findAllByInsuranceType(insuranceType);
    }

    @Override
    public List<Claim> getByStatus(String status) {
        return claimRepository.findAllByStatus(status);
    }

    @Override
    public List<Claim> getByPolicyNumber(String policyNumber) {
        return claimRepository.findAllByPolicyNumber(policyNumber);
    }

    @Override
    public List<String> getAllInsuranceTypes() {
        return claimRepository.findAll().stream()
                .map( claim -> claim.getInsuranceType().toLowerCase())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }
}
