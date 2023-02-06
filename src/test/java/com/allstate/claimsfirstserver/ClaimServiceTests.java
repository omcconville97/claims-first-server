package com.allstate.claimsfirstserver;

import com.allstate.claimsfirstserver.data.ClaimRepository;
import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;
import com.allstate.claimsfirstserver.service.ClaimService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ClaimServiceTests {

    @Autowired
    private ClaimService claimService;

    @MockBean
    private ClaimRepository claimRepository;

    LocalDate now = LocalDate.of(2023, Month.JANUARY,5);
    @Test
    public void testGetAllInsuranceTypes() {
        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim(null, "", "","","", "","", "Pet", now, 0.00, "", "", 0,
                "", "", "", "", "", "", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Home", now, 0.00, "", "", 0,
                "", "", "", "", "", "", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Vehicle", now, 0.00, "", "", 0,
                "", "", "", "", "", "", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Vehicle", now, 0.00, "", "", 0,
                "", "", "", "", "", "", now, ""));
        Mockito.when(claimRepository.findAll()).thenReturn(claims);

        List<String> insuranceType = claimService.getAllInsuranceTypes();
        assertEquals(3, insuranceType.size());
    }

    @Test
    public void testGetAllStatusTypes() {
        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim(null, "", "","","", "","", "Pet", now, 0.00, "", "", 0,
                "", "", "", "", "", "Awaiting Assessment", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Home", now, 0.00, "", "", 0,
                "", "", "", "", "", "Awaiting Assessment", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Vehicle", now, 0.00, "", "", 0,
                "", "", "", "", "", "Rejected", now, ""));
        claims.add(new Claim(null, "", "","","", "","", "Vehicle", now, 0.00, "", "", 0,
                "", "", "", "", "", "Ongoing", now, ""));
        Mockito.when(claimRepository.findAll()).thenReturn(claims);

        List<String> status = claimService.getAllStatusTypes();
        assertEquals(3, status.size());
    }

}
