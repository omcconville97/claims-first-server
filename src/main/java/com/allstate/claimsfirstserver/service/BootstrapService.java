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
      if (claimRepository.count() == 0) {
         Claim claim1 = new Claim(1,"CF101", "Mr", "John", "Smith", "j.smith@gmail.com", "07785345869","Vehicle", firstDate,
               400.00, "Toyota", "Prius", 2014,
               "", "", "", "Exterior damage", "Reversed into tree", "Accepted - Paid", firstDate, "Claim validated and accepted" );

         Claim claim2 = new Claim(2, "CF102", "Mrs", "Jessica", "Bloggs", "j.bloggs@gmail.com", "07854254632",
                 "Home", firstDate, 200.00, "", "", 0,
                 "14 Blue Avenue", "", "", "Flooding", "Burst Pipe", "On Going", firstDate,  "");

         Claim claim3 = new Claim(3, "CF103", "Mr", "Brian", "Jones", "b.jones@gmail.com", "0781542598", "Vehicle", firstDate, 300.00, "Volkswagen", "Passat", 2012,
                 "", "", "", "Engine trouble", "Wrong fuel in car", "Accepted - Paid", firstDate, "Claim validated and accepted");

         Claim claim4 = new Claim(4, "CF104", "Ms", "Rebecca", "Doran", "r.doran@gmail.com", "07854254632", "Pet", firstDate, 150.00, "", "", 0,
                 "", "Dog", "Labrador", "Broken Leg", "Leg trapped", "On Going", firstDate, "Claim validated and waiting on being accepted");

         Claim claim5 = new Claim(5, "CF104", "Ms", "Rebecca", "Doran", "r.doran@gmail.com", "07854254632", "Home", firstDate, 150.00, "", "", 0,
                 "146 Royal Oak", "", "", "", "", "Accepted - Awaiting Payment", firstDate, "Claim Accepted and waiting on customer being paid");

         Claim claim6 = new Claim(6, "CF109", "Mr","Conor","Beattie", "c.beattie@gmail.com","07854254632", "Pet", firstDate, 750.00, "", "", 0,
                 "", "Fish", "Gold Fish", "Surgery", "collapsed gill", "Rejected", firstDate, "Claim rejected as surgery costing over threshold");

         claimRepository.save(claim1);
         claimRepository.save(claim2);
         claimRepository.save(claim3);
         claimRepository.save(claim4);
         claimRepository.save(claim5);
         claimRepository.save(claim6);

      }
   }

}
