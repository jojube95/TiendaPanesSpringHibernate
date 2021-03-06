package com.joan.tiendapanes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.service.ClienteService;

@Controller
@RequestMapping("tienda")
public class Registrar {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST) 
	public String registrar(@ModelAttribute("cliente") Cliente cliente) { 
	    ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.getInitialize();
	    
	    for(Cliente clienteAux : clientes) {
	    	if(clienteAux.getUsuario().equals(cliente.getUsuario())) {
	    		return "registro";
	    	}
	    }
		clienteService.save(cliente);
	    return "logIn"; 
	}

}
