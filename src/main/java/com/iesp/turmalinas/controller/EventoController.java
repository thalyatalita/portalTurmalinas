package com.iesp.turmalinas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iesp.turmalinas.model.Evento;
import com.iesp.turmalinas.service.EventoService;

@Controller
public class EventoController {

	@Autowired
	private EventoService service;
	
	@GetMapping("/listaEventos")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("listEvento");
		mv.addObject("eventos", service.findAll());
		return mv;
	}
	
	@GetMapping("/evento")
    public ModelAndView eventos(Evento evento) {
        ModelAndView mv = new ModelAndView("/addEvento");
        mv.addObject("evento", evento);
		return mv;
    }
	
	@PostMapping("/eventoCadastrado")
    public String addUser(Evento evento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addEvento";
        }
         
        service.save(evento);
        model.addAttribute("eventos", service.findAll());
        return "listEvento";
    }
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Evento evento = service.findOne(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("evento", evento);
	    return "editEvento";
	}
	
	@PostMapping("/update/{id}") 
	public String edit(Evento evento, @PathVariable("id") Long id, Model model, BindingResult result) { 
		if (result.hasErrors()) {
			evento.setId(id);
	        return "editEvento";
	    }
		service.save(evento);
		model.addAttribute("eventos", service.findAll());
		return "listEvento";
		}	
}
