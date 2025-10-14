package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import java.util.List;

public interface IServiceMedecin {

    public Medecin addMedecin(Medecin medecin);
    public List<Medecin> getAllMedecins();
}
