package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.data.ClaimRepository;
import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims(){
        List<Claim> claims = claimRepository.findAll();
        System.out.println("There were " + claims.size() + " claims found");
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
    public List<String> getAllStatusTypes() {
        return claimRepository.findAll().stream()
                .map( claim -> claim.getStatus().toLowerCase())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public Claim updateClaim(Integer id, Map<String, Object> fields) {
        Claim claim = claimRepository.findById(id).get(); //should really check it is there + throw an exception

        if (fields.containsKey("policyNumber")) {
            claim.setPolicyNumber(fields.get("policyNumber").toString());
        }
        if (fields.containsKey("title")) {
            claim.setTitle(fields.get("title").toString());
        }
        if (fields.containsKey("firstName")) {
            claim.setFirstName(fields.get("firstName").toString());
        }
        if (fields.containsKey("surname")) {
            claim.setSurname(fields.get("surname").toString());
        }
        if (fields.containsKey("email")) {
            claim.setEmail(fields.get("email").toString());
        }
        if (fields.containsKey("phoneNumber")) {
            claim.setPhoneNumber(fields.get("phoneNumber").toString());
        }
        if (fields.containsKey("insuranceType")) {
            claim.setInsuranceType(fields.get("insuranceType").toString());
        }
        if (fields.containsKey("estimatedWorth")) {
            claim.setEstimatedWorth(Double.parseDouble(fields.get("estimatedWorth").toString()));
        }
        if (fields.containsKey("vehicleMake")) {
            claim.setVehicleMake(fields.get("vehicleMake").toString());
        }
        if (fields.containsKey("vehicleModel")) {
            claim.setVehicleModel(fields.get("vehicleModel").toString());
        }
        if (fields.containsKey("vehicleYear")) {
            claim.setVehicleYear(Integer.parseInt(fields.get("vehicleYear").toString()));
        }
        if (fields.containsKey("propertyAddress")) {
            claim.setPropertyAddress(fields.get("propertyAddress").toString());
        }
        if (fields.containsKey("animalType")) {
            claim.setAnimalType(fields.get("animalType").toString());
        }
        if (fields.containsKey("animalBreed")) {
            claim.setAnimalBreed(fields.get("animalBreed").toString());
        }
        if (fields.containsKey("reason")) {
            claim.setReason(fields.get("reason").toString());
        }
        if (fields.containsKey("description")) {
            claim.setDescription(fields.get("description").toString());
        }
        if (fields.containsKey("status")) {
            claim.setStatus(fields.get("status").toString());
        }
        if (fields.containsKey("taskNote")) {
            claim.setTaskNote(fields.get("taskNote").toString());
        }
//        if (fields.containsKey("taskDate")) {
//            claim.setTaskDate((Date) fields.get("taskDate"));
//        }
//        if (fields.containsKey("date")) {
//            claim.setDate((Date) fields.get("date"));
//        }

        if (fields.containsKey("taskDate")) {
            claim.setTaskDate(LocalDate.parse(fields.get("taskDate").toString()));
        }
        if (fields.containsKey("date")) {
            claim.setDate(LocalDate.parse(fields.get("date").toString()));
        }
        return claimRepository.save(claim);
    }
}
