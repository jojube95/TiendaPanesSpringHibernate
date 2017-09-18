package com.joan.tiendapanes.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.entity.PanVenta;
import com.joan.tiendapanes.entity.Venta;
import com.joan.tiendapanes.service.ClienteService;
import com.joan.tiendapanes.service.VentaService;

@Controller
@RequestMapping("tienda")
public class VerCompras {

	@Autowired 
	private HttpSession httpSession;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VentaService ventaService;
	
	
	@RequestMapping("/verCompras")
	public String verCompras(Model model) {
		//Cojer el idCliente del httpSession
		Cliente cliente = (Cliente)httpSession.getAttribute("cliente");
		
		//Cojer el cliente de hibernate
		cliente = clienteService.getInitialize(cliente.getIdCliente());
		
		//Cojer las compras del cliente
		List<Venta> ventas = cliente.getVentas();
		
		//Añadirlas al modelo para mostrarlas despues
		model.addAttribute("compras", ventas); 
		return "compras";
	}
	
	@RequestMapping("/panesCompra")
	public String mostrarPanesCompra(@RequestParam(value = "idCompra", required = false) int idCompra, ModelMap model) {
		//Cojer la venta de hibernate con el idCompra
		Venta venta = ventaService.getInitialize(idCompra);
		model.addAttribute("compra", venta);			
		//Cojer los panes de la venta
		List<PanVenta> panesCompra = venta.getPanVentas();
		
		//Añadirlas al modelo para mostrarlas despues
		model.addAttribute("panesCompra", panesCompra); 
		return "panesCompra";
	}
	
	
	
}
