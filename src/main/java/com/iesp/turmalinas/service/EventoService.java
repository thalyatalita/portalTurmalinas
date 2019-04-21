package com.iesp.turmalinas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesp.turmalinas.model.Evento;
import com.iesp.turmalinas.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}
	
	public Optional<Evento> findOne(Long id) {
		return eventoRepository.findById(id);
	}
	
	public Evento save(Evento evento) {
		return eventoRepository.saveAndFlush(evento);
	}
	
	public void delete(Long id) {
		eventoRepository.deleteById(id);
	}
}
