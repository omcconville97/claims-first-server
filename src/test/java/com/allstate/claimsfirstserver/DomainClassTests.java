package com.allstate.claimsfirstserver;

import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.domain.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainClassTests {

    @Test
    public void test2ClaimsWithTheSameIdAreEqual() {
        Claim claim1 = new Claim();
        Claim claim2 = new Claim();
        claim1.setId(123);
        claim2.setId(123);
        assertEquals(claim1, claim2);
    }
    @Test
    public void test2TasksWithTheSameIdAreEqual() {
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setId(10);
        task2.setId(10);
        assertEquals(task1, task2);
    }

}