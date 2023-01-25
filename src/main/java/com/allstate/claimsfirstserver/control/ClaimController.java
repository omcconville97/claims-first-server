package com.allstate.claimsfirstserver.control;

import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;
import com.allstate.claimsfirstserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<Claim> getAllClaims(@RequestParam(value = "insuranceType", required = false) String insuranceType,
                                    @RequestParam(value = "status", required = false) String status) {
        if (status != null){
            return claimService.getByStatus(status);
        }
        else if (insuranceType != null) {
            return claimService.getByInsuranceType(insuranceType);
        }
        else {
            return claimService.getAllClaims();
        }
    }

    @GetMapping("/policy")
    public List<Claim> getByPolicyNumber(@RequestParam(value = "policyNumber", required = false) String policyNumber) {
        return claimService.getByPolicyNumber(policyNumber);
    }

    @GetMapping("/{id}")
    public Claim findById(@PathVariable Integer id) throws ClaimNotFoundException {
        return claimService.getById(id);
    }

    @PostMapping
    public Claim saveNewClaim(@RequestBody Claim claim) {
        System.out.println(claim);
        return claimService.saveClaim(claim);
    }
}
