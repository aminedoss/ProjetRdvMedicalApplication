package com.app.rdv.service;

import com.app.rdv.entities.Rdv;
import java.util.List;
public interface IServiceRdv {
    public Rdv addRdv(Rdv rdv);
    public List<Rdv> getAllRdvs();
}
