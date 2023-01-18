package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.data.ClaimRepository;
import com.allstate.claimsfirstserver.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class BootstrapService {
   Date firstDate = new Date();

   @Autowired
   private ClaimRepository claimRepository;

   @PostConstruct
   public void setUpInitialData(){
      int numberOfClaims = claimRepository.findAll().size();
      if (numberOfClaims == 0) {
         Claim newClaim = new Claim(1,"CF101", "Mr", "John", "Smith", "j.smith@gmail.com", "07785345869","Vehicle", firstDate,
               400.00, "Toyota", "Prius", 2014,
               "", "", "", "Exterior damage", "Reversed into tree", "Accepted - Paid", firstDate, "Claim validated and accepted" );
         Claim savedClaim = claimRepository.save(newClaim);
         //this automatically will add an id to the car because autogenerate starts at null
         System.out.println("Claim saved with id " + savedClaim.getId());
      }
   }

}
