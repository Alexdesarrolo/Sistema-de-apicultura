package com.BeeCare_Proyecto.BeeCare.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador2 {
	
	@GetMapping("/login2")
	public String iniciarSesion() {
		return "prueba";
	}
}