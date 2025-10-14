package com.app.rdv.service;

import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv{
    RdvRepository rdvRepository;
    @Override
    public Rdv addRdv(Rdv rdv) {
        Rdv rdv1 = rdvRepository.findRdvByMedecinIdAndDateRdv(rdv.getMedecin().getId(), rdv.getDateRdv());
        Rdv rdv2 = rdvRepository.findRdvByPatientIdAndDateRdv(rdv.getPatient().getId(), rdv.getDateRdv());
        if(rdv1==null||rdv2==null)
            return rdvRepository.save(rdv);
        else
            return null;
    }

    @Override
    public List<Rdv> getAllRdvs() {

        return rdvRepository.findAllByOrderByDateRdvAsc();
    }
}
