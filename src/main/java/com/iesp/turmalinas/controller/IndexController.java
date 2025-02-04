package com.iesp.turmalinas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	  public String login() {
	    return "login"; 
	  }
	
	@GetMapping("/gerenciamento")
	  public String gerenci() {
	    return "gerenciamento"; 
	  }
   
	@GetMapping("/membros")
	public String membros() {
		return "membros";
	}
	
	@GetMapping("/produtos")
	public String produtos() {
		return "produtos";
	}
}
