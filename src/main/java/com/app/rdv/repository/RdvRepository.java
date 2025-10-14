package com.app.rdv.repository;

import com.app.rdv.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
    Rdv findRdvByPatientIdAndDateRdv(int id, LocalDateTime date);

    Rdv findRdvByMedecinIdAndDateRdv(int id, LocalDateTime date);


    List<Rdv> findAllByOrderByDateRdvAsc();
}
