package com.luv2code.springdemo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv2code.springdemo.entity.Cliente;
import com.luv2code.springdemo.service.ClienteService;

@Controller
@RequestMapping("tienda")
public class LogIn {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired 
	private HttpSession httpSession;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("cliente", new Cliente()); 
	    return "logIn"; 
	}
	
	@RequestMapping("/logIn")
	public String logIn(@ModelAttribute("cliente") Cliente cliente) {
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.getInitialize();
		boolean existe = false;
		
		for(Cliente c : clientes) {
			if(c.getUsuario().equals(cliente.getUsuario()) && c.getContrasenya().equals(cliente.getContrasenya())) {
				httpSession.setAttribute("cliente", c);
				existe = true;
				break;
			}
		}
		
		if(existe) {
			return "usuario";
		}
		else {
			return "logIn";
		}
		
	}
	
	@RequestMapping("/mostrarRegistrar")
	public String mostrarRegistrar(Model model) {
		model.addAttribute("cliente", new Cliente()); 
		return "registro";
	}
		
	
}


