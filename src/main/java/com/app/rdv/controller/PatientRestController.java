package com.app.rdv.controller;

import com.app.rdv.entities.Patient;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patient")
public class PatientRestController {

    IServicePatient iServicePatient;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public Patient add(@RequestBody Patient patient){
        return iServicePatient.addPatient(patient);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN', 'SCOPE_ROLE_USER')")
    public List<Patient> all(){
        return iServicePatient.getAllPatients();
    }
}