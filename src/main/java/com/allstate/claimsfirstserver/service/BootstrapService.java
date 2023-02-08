package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.data.ClaimRepository;
import com.allstate.claimsfirstserver.data.TaskRepository;
import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;

@Service
public class BootstrapService {
   @Autowired
   private ClaimRepository claimRepository;

   @Autowired
   TaskRepository taskRepository;

   @PostConstruct
   public void setUpInitialData(){
      if (claimRepository.count() == 0) {
         Claim claim1 = new Claim(1,"CF101", "Mr", "John", "Smith", "j.smith@gmail.com", "07785345869","Vehicle", LocalDate.of(2023, Month.JANUARY,5),
               400.00, "Toyota", "Prius", 2014,
               "", "", "", "Exterior damage", "Reversed into tree", "Accepted - Paid", LocalDate.of(2023, Month.JANUARY,5), "Claim validated and accepted" );

         Claim claim2 = new Claim(2, "CF102", "Mrs", "Jessica", "Bloggs", "j.bloggs@gmail.com", "07854254632",
                 "Home", LocalDate.of(2023, Month.JANUARY,5), 200.00, "", "", 0,
                 "14 Blue Avenue", "", "", "Flooding", "Burst Pipe", "On Going", LocalDate.of(2023, Month.JANUARY,5),  "");

         Claim claim3 = new Claim(3, "CF103", "Mr", "Brian", "Jones", "b.jones@gmail.com", "0781542598", "Vehicle", LocalDate.of(2023, Month.JANUARY,5), 300.00, "Volkswagen", "Passat", 2012,
                 "", "", "", "Engine trouble", "Wrong fuel in car", "Accepted - Paid", LocalDate.of(2023, Month.JANUARY,5), "Claim validated and accepted");

         Claim claim4 = new Claim(4, "CF104", "Ms", "Rebecca", "Doran", "r.doran@gmail.com", "07854254632", "Pet", LocalDate.of(2023, Month.JANUARY,5), 150.00, "", "", 0,
                 "", "Dog", "Labrador", "Broken Leg", "Leg trapped", "On Going", LocalDate.of(2023, Month.JANUARY,5), "Claim validated and waiting on being accepted");

         Claim claim5 = new Claim(5, "CF104", "Ms", "Rebecca", "Doran", "r.doran@gmail.com", "07854254632", "Home", LocalDate.of(2023, Month.JANUARY,5), 150.00, "", "", 0,
                 "146 Royal Oak", "", "", "", "", "Accepted - Awaiting Payment", LocalDate.of(2023, Month.JANUARY,5), "Claim Accepted and waiting on customer being paid");

         Claim claim6 = new Claim(6, "CF109", "Mr","Conor","Beattie", "c.beattie@gmail.com","07854254632", "Pet", LocalDate.of(2023, Month.JANUARY,5), 750.00, "", "", 0,
                 "", "Fish", "Gold Fish", "Surgery", "collapsed gill", "Rejected", LocalDate.of(2023, Month.JANUARY,5), "Claim rejected as surgery costing over threshold");

         Claim claim7 = new Claim(7, "CF109", "Mr","Conor","Beattie", "c.beattie@gmail.com","07854254632", "Home", LocalDate.of(2023, Month.JANUARY,5), 450.00, "", "", 0,
                 "19 LakeLand View", "", "", "Brick Damage", "Adverse weather condition", "Awaiting Assessment", LocalDate.of(2023, Month.JANUARY,5), "");

         Claim claim8 = new Claim(8, "CF110", "Mrs","Emma","Grant", "e.grant@gmail.com","07757254652", "Vehicle", LocalDate.of(2023, Month.JANUARY,5), 250.00, "Audi", "TT", 2018,
                 "", "", "", "Alloy Damage", "Drove into kerb", "On Going", LocalDate.of(2023, Month.JANUARY,5), "Further investigation required");

         Claim claim9 = new Claim(9, "CF110", "Mrs","Emma","Grant", "e.grant@gmail.com","07757254652", "Home", LocalDate.of(2023, Month.JANUARY,5), 340.00, "", "", 0,
                 "39 Pleasant Park", "", "", "Electrical Damage", "Faulty damaged good", "Accepted - Awaiting Payment", LocalDate.of(2023, Month.JANUARY,5), "Claim Accepted and waiting on customer being paid");

         claimRepository.save(claim1);
         claimRepository.save(claim2);
         claimRepository.save(claim3);
         claimRepository.save(claim4);
         claimRepository.save(claim5);
         claimRepository.save(claim6);
         claimRepository.save(claim7);
         claimRepository.save(claim8);
         claimRepository.save(claim9);
      }

      if (taskRepository.count() == 0) {
         Task task1 = new Task(1, "CF101", "Call Back client", false);
         Task task2 = new Task(2, "CF103", "Call Back client", false);

         taskRepository.save(task1);
         taskRepository.save(task2);
      }
   }

}
