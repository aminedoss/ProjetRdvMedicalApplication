package com.app.rdv.service;

import com.app.rdv.entities.Patient;

import java.util.List;

public interface IServicePatient {

    public Patient addPatient(Patient patient);
    public List<Patient> getAllPatients();
}
