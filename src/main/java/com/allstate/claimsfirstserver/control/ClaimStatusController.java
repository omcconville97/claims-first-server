package com.allstate.claimsfirstserver.control;

import com.allstate.claimsfirstserver.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/status")
public class ClaimStatusController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<String> getAllStatusTypes() {
        return claimService.getAllStatusTypes();
    }
}
