package com.joan.tiendapanes.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.entity.PanTienda;
import com.joan.tiendapanes.entity.PanVenta;
import com.joan.tiendapanes.entity.Tienda;
import com.joan.tiendapanes.entity.Venta;
import com.joan.tiendapanes.service.ClienteService;
import com.joan.tiendapanes.service.TiendaService;
import com.joan.tiendapanes.service.VentaService;

@Controller
@RequestMapping("tienda")
public class Comprar {

	@Autowired
	private VentaService VentaService;
	
	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired 
	private HttpSession httpSession;
	
	
	@RequestMapping("/mostrarTiendas")
	public String mostrarRegistrar(Model model) {
		httpSession.removeAttribute("tienda");
		
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		
		model.addAttribute("tiendas", tiendas); 
		return "tiendas";
	}
	
	@RequestMapping("/comprar")
	public String comprar(@RequestParam("idTienda") int theId) {
		
		Tienda tienda = tiendaService.getInitialize(theId);
		httpSession.setAttribute("tienda", tienda);
		
		httpSession.setAttribute("panesTienda", tienda.getPanesTienda());
		
		return "catalogo";
	}
	
	@RequestMapping("/volverAUsuario")
	public String volcerAUsuario() {
		return "usuario";
	}
	
	@RequestMapping("/hacerCompra")
	public String hacerCompra(HttpServletRequest request) {
		Enumeration paramaterNames = request.getParameterNames();
		paramaterNames.nextElement();
		ArrayList<PanTienda> panesVenta = new ArrayList<>();
		Tienda tienda = (Tienda) httpSession.getAttribute("tienda");
		tienda = tiendaService.getInitialize(tienda.getIdTienda());
		Cliente cliente = (Cliente) httpSession.getAttribute("cliente");
		cliente = clienteService.getInitialize(cliente.getIdCliente());
		
		//Cojer los panesTienda de hibernate
		List<PanTienda> panesTienda = (List<PanTienda>) httpSession.getAttribute("panesTienda");
		
		while(paramaterNames.hasMoreElements() ) {
			int idPan = Integer.parseInt(request.getParameter((String) paramaterNames.nextElement()));
			int cant = Integer.parseInt(request.getParameter((String) paramaterNames.nextElement()));
			
			//Añadir el pan del stock a la venta
			for(int i = 0; i < panesTienda.size(); i++){
				if(panesTienda.get(i).getIdPanTienda() == idPan){
					PanTienda panTienda = new PanTienda(panesTienda.get(i).getPan(), cant, tienda, panesTienda.get(i).getPanFabrica());
					//añadir un id al panTienda, que no lo haga hibernate
					panesVenta.add(panTienda);
				}
			}

		}
		//Apanyar panesVenta, junta duplicados
		for(int i = 0; i < panesVenta.size(); i++){
			for(int j = 0; j < panesVenta.size(); j++){
				if((panesVenta.get(i).getPanFabrica().getIdPan() == panesVenta.get(j).getPanFabrica().getIdPan()) && i!=j){
					panesVenta.get(i).setCant(panesVenta.get(i).getCant() + panesVenta.get(j).getCant());
					panesVenta.remove(j);
				}
			}
		}
		
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		
		//Crear la venta, no esta lista para ser insertada en la base de datos
		Venta venta = new Venta(date, true, (float) 0.0);
		
		for(PanTienda panTienda : panesVenta) {
			
			//Cojer los panTienda antes de la base de datos
			//panTiendaService.save(panTienda);
			
			PanVenta panVenta = new PanVenta();
			panVenta.getId().setVenta(venta);
			panVenta.getId().setPanTienda(panTienda);
			panVenta.setCant(panTienda.getCant());
			venta.getPanVentas().add(panVenta);
		}
		venta.setPrecio();
		
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
						
		
		httpSession.setAttribute("compra", venta);
		return "confirmar";
	}
	
	@RequestMapping("/confirmar")
	public String confirmar() {
		Venta venta = (Venta) httpSession.getAttribute("compra");
		Venta venta2 = new Venta(venta.getFecha(), true, venta.getPrecio());
		//Contruir la venta con objetos sacados de hibernate
		
		//Cojer el cliente
		Cliente cliente = clienteService.getInitialize(venta.getCliente().getIdCliente());
		//Cojer la tienda
		Tienda tienda = tiendaService.getInitialize(venta.getTienda().getIdTienda());
		//Seleccionar los panesTienda que tengan el mismo nombre que en la venta
		ArrayList<PanTienda> panesTienda = new ArrayList<>();
		for(int i = 0; i < tienda.getPanesTienda().size(); i++) {
			for(int j = 0; j < venta.getPanVentas().size(); j++) {
				if(tienda.getPanesTienda().get(i).getPan().getNombre().equals(venta.getPanVentas().get(j).getPanTienda().getPan().getNombre())) {
					panesTienda.add(tienda.getPanesTienda().get(i));
					panesTienda.get(i).setCant(venta.getPanVentas().get(j).getCant());
				}
			}
		}
		
		//Unir todas las dependencias con los objetos java
		venta2.setCliente(cliente);
		cliente.getVentas().add(venta2);
		
		tienda.getVentas().add(venta2);
		venta2.setTienda(tienda);
		
		for(PanTienda panTienda : panesTienda) {
			PanVenta panVenta = new PanVenta();
			panVenta.getId().setVenta(venta2);
			panVenta.getId().setPanTienda(panTienda);
			//Ver si la cantidad corresponde a la venta
			panVenta.setCant(panTienda.getCant());
			venta2.getPanVentas().add(panVenta);
		}
		//Guardar la venta
		VentaService.save(venta2);
		return "usuario";
	}
	
	@RequestMapping("/volverACompra")
	public String volverACompra() {
		
		return "catalogo";
	}
}
