package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv")
public class RdvRestController {
    IServiceRdv iServiceRdv;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public ResponseEntity<?> add(@RequestBody Rdv rdv){

        Rdv rdv1 = iServiceRdv.addRdv(rdv);

        if (rdv1 != null)
            return new ResponseEntity<>(rdv1, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Conflit: Le médecin ou le patient a déjà un rendez-vous à cette date", HttpStatus.CONFLICT);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('SCOPE_ROLE_ADMIN', 'SCOPE_ROLE_USER')")
    public List<Rdv> all(){
        return iServiceRdv.getAllRdvs();
    }
}