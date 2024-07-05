package com.BeeCare_Proyecto.BeeCare.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Menu {
	
	@GetMapping({"/menu"})
	public String menu() {
		
		return "index";
	}
}
