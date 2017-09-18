package com.joan.tiendapanes.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.entity.PanTienda;
import com.joan.tiendapanes.entity.PanVenta;
import com.joan.tiendapanes.entity.Tienda;
import com.joan.tiendapanes.entity.Venta;
import com.joan.tiendapanes.service.ClienteService;
import com.joan.tiendapanes.service.PanTiendaService;
import com.joan.tiendapanes.service.TiendaService;
import com.joan.tiendapanes.service.VentaService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
@EnableTransactionManagement
public class VentaDAOTest {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private PanTiendaService panTiendaService;
	
	final Date fecha = new Date(10);
	final boolean online = true;
	final float precio = (float) 69.69;
	
	Cliente cliente;
	Tienda tienda;
	PanTienda panTienda;
	
	//Hay que poner la Tienda y el Cliente cargados de la base de datos;
	@Test
	@Before
	@Transactional
	public void beforeTest(){
		//Cargar el cliente, la tienda y el pan de la base de datos
		cliente = clienteService.get().get(0);
		tienda = tiendaService.getInitialize().get(0);
		panTienda = panTiendaService.get().get(0);
		
	}
	
		
	@Test
	@Transactional
	@Rollback(true)
	public void testEscrituraVentaClienteTiendaPanes(){
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
		venta.setCliente(cliente);
		cliente.getVentas().add(venta);
				
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		PanVenta panVenta = new PanVenta();
		panVenta.getId().setVenta(venta);
		panVenta.getId().setPanTienda(panTienda);
		panVenta.setCant(69);
		venta.getPanVentas().add(panVenta);
		
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
				
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertNotNull(venta.getPanVentas().get(0));
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testEscrituraVentaClienteTiendaSinPanes(){
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
						
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
				
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertEquals(venta.getPanVentas().size(), 0);
		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaVentaTiendaClientePanes() {
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
		PanVenta panVenta = new PanVenta();
		panVenta.getId().setVenta(venta);
		panVenta.getId().setPanTienda(panTienda);
		panVenta.setCant(69);
		venta.getPanVentas().add(panVenta);
		
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		
				
		
		
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();	
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertNotNull(venta.getPanVentas().get(0));
		
		//Leer y comprobar
		Venta venta2 = ventaService.get(idVenta);
		
		assertEquals(venta2.isOnline(), true);
		assertEquals(venta2.getPanVentas().size(), 1);
		        
    }
	
	
	
	
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaVentaTiendaClientePanesInitialize() {
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		//Cojer el panTienda de la base de datos
		PanTienda panTienda = panTiendaService.get().get(0);
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		PanVenta panVenta = new PanVenta();
		panVenta.getId().setVenta(venta);
		panVenta.getId().setPanTienda(panTienda);
		panVenta.setCant(69);
		venta.getPanVentas().add(panVenta);
				
		
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();	
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertNotNull(venta.getPanVentas().get(0));
		
		//Leer y comprobar
		Venta venta2 = ventaService.getInitialize(idVenta);
		
		assertEquals(venta2.isOnline(), true);
		assertEquals(venta2.getPanVentas().size(), 1);
        
    }
    
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloVentas(){
		ArrayList<Venta> ventas = (ArrayList<Venta>) ventaService.get();
		assertTrue(ventas.size() > 0);
		
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloVentasInitialize(){
		ArrayList<Venta> ventas = (ArrayList<Venta>) ventaService.getInitialize();
		assertTrue(ventas.size() > 0);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaVentaTiendaClientePanes(){
		ArrayList<Venta> ventas = (ArrayList<Venta>) ventaService.get();
		assertTrue(ventas.size() > 0);
		assertNotNull(ventas.get(0).getCliente());
		assertNotNull(ventas.get(0).getTienda());
		assertTrue(ventas.get(0).getPanVentas().size() > 0);
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaVentaClienteTiendaPanesInitialize(){
		ArrayList<Venta> ventas = (ArrayList<Venta>) ventaService.getInitialize();
		assertTrue(ventas.size() > 0);
		assertNotNull(ventas.get(0).getCliente());
		assertNotNull(ventas.get(0).getTienda());
		assertTrue(ventas.get(0).getPanVentas().size() > 0);
	}
	
	
	
	//Usar el getInitialize(int);
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateSoloVenta(){
		final boolean ONLINE = false;
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
				
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertEquals(venta.getPanVentas().size(), 0);
        
        venta.setOnline(ONLINE);
        
        ventaService.update(venta);
        
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertEquals(venta2.isOnline(), ONLINE);
        
	}
	//usar el getInitialize(int);
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVentaCliente(){
		
		final String USUARIO = "usuarioUpdate";
		
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
				
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertEquals(venta.getPanVentas().size(), 0);
        
        venta.getCliente().setUsuario(USUARIO);
        
        ventaService.update(venta);
        
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertEquals(venta2.getCliente().getUsuario(), USUARIO);
				
	}
	//usar el getInitialize(int);
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVentaTienda(){
		final String NOMBRE = "nombreUpdate";
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
				
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertEquals(venta.getPanVentas().size(), 0);
        
        venta.getTienda().setNombre(NOMBRE);
        
        ventaService.update(venta);
        
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertEquals(venta2.getTienda().getNombre(), NOMBRE);
		
		
	}
	
	//usar el gerInitiazlies(int)
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVentaPan(){
		final int CANTIDAD = 11;
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Cojer el panTienda de la base de datos
		PanTienda panTienda = panTiendaService.get().get(0);
				
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		PanVenta panVenta = new PanVenta();
		panVenta.getId().setVenta(venta);
		panVenta.getId().setPanTienda(panTienda);
		panVenta.setCant(69);
		venta.getPanVentas().add(panVenta);
				
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();
		
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertTrue(venta.getPanVentas().size() > 0);
        
        venta.getPanVentas().get(0).setCant(CANTIDAD);
        
        ventaService.update(venta);
        
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertEquals(venta2.getPanVentas().get(0).getCant(), CANTIDAD);
		
		
	}
	
		
	//Comprobar que elimina solo la venta y sus panes, no elimina Tienda y Cliente
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVenta(){
		//Crear la venta
		Venta venta = new Venta(fecha, online, precio);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		//Cojer el panTienda de la base de datos
		PanTienda panTienda = panTiendaService.get().get(0);
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		PanVenta panVenta = new PanVenta();
		panVenta.getId().setVenta(venta);
		panVenta.getId().setPanTienda(panTienda);
		panVenta.setCant(69);
		venta.getPanVentas().add(panVenta);
		
		
		
		//guardar la venta, deberia guardarse lo otro
		ventaService.save(venta);
		int idVenta = venta.getIdVenta();
		int idCliente = venta.getCliente().getIdCliente();
		int idTienda = venta.getTienda().getIdTienda();
				
		//comprobar que ha insertado lo otro
		assertThat(venta.getIdVenta(), not(0));
		assertNotNull(venta.getPanVentas().get(0));
		
		//Eliminar la venta
		ventaService.delete(venta);
		 
        //Comprobar que la venta se ha eliminado
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertNull(venta2);
        //Comprobar que los panes de la venta se han eliminado
        //?
        
        //Comprobar que la tienda y el cliente no se han eliminado
        Cliente cliente2 = clienteService.getInitialize(idCliente);
        assertNotNull(cliente2);
        Tienda tienda2 = tiendaService.getInitialize(idTienda);
        assertNotNull(tienda2);
	}
	
	
	
}
