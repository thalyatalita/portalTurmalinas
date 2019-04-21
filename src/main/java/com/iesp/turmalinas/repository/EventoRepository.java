package com.iesp.turmalinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesp.turmalinas.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
