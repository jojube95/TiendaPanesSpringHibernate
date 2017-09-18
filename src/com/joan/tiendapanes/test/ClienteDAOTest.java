package com.joan.tiendapanes.test;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.entity.Tienda;
import com.joan.tiendapanes.entity.Venta;
import com.joan.tiendapanes.service.ClienteService;
import com.joan.tiendapanes.service.TiendaService;
import com.joan.tiendapanes.service.VentaService;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
public class ClienteDAOTest{
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private TiendaService tiendaService;
	
	
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituaSoloCliente() {
        // Just a write, verify id set
        Cliente cliente = new Cliente();
        cliente.setNombre("nombre test");
        cliente.setLocalidad("localidad test");
        cliente.setFechaNacimiento(new Date(10));
        cliente.setUsuario("usuario test");
        cliente.setContrasenya("pass test");
        cliente.setOnline(true);
        assertEquals(0, cliente.getIdCliente());
        clienteService.save(cliente);
        assertThat(cliente.getIdCliente(), not(0));
        
       
    }
	
	
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaSoloCliente() {
		String nombre = "NombreDefault";
		String localidad = "LocalidadDefault";
		Date fechaNacimiento = new Date(10);
		String usuario = "UsuarioDefault";
		String pass = "PassDefault";
		Boolean online = true;
		
		// Just a write, verify id set
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setLocalidad(localidad);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setUsuario(usuario);
        cliente.setContrasenya(pass);
        cliente.setOnline(online);
        assertEquals(0, cliente.getIdCliente());
        clienteService.save(cliente);
        assertNotNull(cliente.getIdCliente());
 
        // Read and verify
        Cliente cliente2  = new Cliente();
                
        cliente2 = clienteService.getInitialize(cliente.getIdCliente());
        
        assertEquals(cliente2.getNombre(), nombre);
        assertEquals(cliente2.getLocalidad(), localidad);
        assertEquals(cliente2.getUsuario(), usuario);
        assertEquals(cliente2.getContrasenya(), pass);
        assertEquals(cliente2.isOnline(), online);
        
    }
	
	
	//Hay que poner la tienda ya cargada de la base de datos
	
	@Test
	@Transactional
	@Rollback(true)
	public void testEscrituraClienteVenta(){
		//Crear el clietne
		Cliente cliente = new Cliente("NombreTest", "LocalidadTest", new Date(10));
		//Ver que el cliente aun no se ha insertado
		//assertEquals(0, cliente.getIdCliente());
		//Cojer la tienda con el id de la base de datos directamente
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		Tienda tienda = tiendas.get(0);
		
		//Crear la venta
		Venta venta = new Venta(new Date(10), true, (float)10.5);
		//ver que la venta aun no se ha insertado
		//assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
				
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		//guardar el cliente, deberia guardarse lo otro
		clienteService.save(cliente);
			
		
		//comprobar que ha insertado lo otro
		assertThat(cliente.getIdCliente(), not(0));
		assertThat(tienda.getIdTienda(), not(0));
		assertThat(venta.getIdVenta(), not(0));
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaSoloClienteInitialize() {
		String nombre = "NombreDefault";
		String localidad = "LocalidadDefault";
		Date fechaNacimiento = new Date(10);
		String usuario = "UsuarioDefault";
		String pass = "PassDefault";
		Boolean online = true;
		
		// Just a write, verify id set
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setLocalidad(localidad);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setUsuario(usuario);
        cliente.setContrasenya(pass);
        cliente.setOnline(online);
        assertEquals(0, cliente.getIdCliente());
        clienteService.save(cliente);
        assertThat(cliente.getIdCliente(), not(0));
 
        // Read and verify
        Cliente cliente2  = new Cliente();
                
        cliente2 = clienteService.getInitialize(cliente.getIdCliente());
        
        assertEquals(cliente2.getNombre(), nombre);
        assertEquals(cliente2.getLocalidad(), localidad);
        //assertTrue((cliente2.getFechaNacimiento().compareTo(fechaNacimiento)) == 0);
        assertEquals(cliente2.getUsuario(), usuario);
        assertEquals(cliente2.getContrasenya(), pass);
        assertEquals(cliente2.isOnline(), online);
        
    }
    
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloClientes(){
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.get();
		assertTrue(clientes.size() > 0);
		
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloClientesInitialize(){
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.getInitialize();
		assertTrue(clientes.size() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaClienteVentaPanesInitialize(){
		Cliente cliente = clienteService.getInitialize(1);
		assertTrue(cliente.getVentas().size() > 0);
		assertTrue(cliente.getVentas().get(0).getPanVentas().size() > 0);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaClienteVenta(){
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.get();
		assertTrue(clientes.size() > 0);
		assertTrue(clientes.get(0).getVentas().size() > 0);
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaClienteVentaInitialize(){
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteService.getInitialize();
		assertTrue(clientes.size() > 0);
		assertTrue(clientes.get(0).getVentas().size() > 0);
	}
	
	
	
	//El get con join fetch
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateSoloCliente(){
		final String NOMBRETEST = "NOMBRETEST";
		
		Cliente cliente = new Cliente("nombre test", "loclaidad test", new Date(10));
		
		assertEquals(0, cliente.getIdCliente());
        clienteService.save(cliente);
        assertThat(cliente.getIdCliente(), not(0));
        int id = cliente.getIdCliente();
        
        cliente.setNombre(NOMBRETEST);
        
        clienteService.update(cliente);
        
        Cliente cliente2  = clienteService.getInitialize(id);
        assertEquals(cliente2.getNombre(), NOMBRETEST);
        
        
        
	}
	
	
	//hay que cojer la tienda de la base de datos directamente
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateClienteVenta(){
		final boolean ONLINE = false;
		
		//Crear el clietne
		Cliente cliente = new Cliente("NombreTest", "LocalidadTest", new Date(10));
		//Ver que el cliente aun no se ha insertado
		assertEquals(0, cliente.getIdCliente());
		//Cojer la tienda con el id de la base de datos directamente
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		Tienda tienda = tiendas.get(0);		
		
		//Crear la venta
		Venta venta = new Venta(new Date(10), true, (float)10.5);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		//guardar el cliente, deberia guardarse lo otro
		clienteService.save(cliente);
		int idCliente = cliente.getIdCliente();
		
		
		//comprobar que ha insertado lo otro
		assertThat(cliente.getIdCliente(), not(0));
		assertThat(tienda.getIdTienda(), not(0));
		assertThat(venta.getIdVenta(), not(0));
		
		//Comprobar el update
		cliente.getVentas().get(0).setOnline(ONLINE);;
        
        clienteService.update(cliente);
        
        Cliente cliente2  = clienteService.getInitialize(idCliente);
        assertEquals(cliente2.getVentas().get(0).isOnline(), ONLINE);
		
		
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteClienteSinVentas(){
		Cliente cliente = new Cliente("nombreTest", "localidadTest", new Date(10));
        
        // Write
        
        clienteService.save(cliente);
        int id = cliente.getIdCliente();
        assertThat(cliente.getIdCliente(), not(0));
 
        // Delete it now
        clienteService.delete(cliente);
 
        // Now we can't read it back, as expected
        Cliente cliente2 = clienteService.getInitialize(id);
        assertNull(cliente2);
	}
	
	
	//Comprobar que elimina tambien las ventas, no se puede poner que no las elimine porque la relacion es 1-N
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteClienteConVentas(){
		//Crear el clietne
		Cliente cliente = new Cliente("NombreTest", "LocalidadTest", new Date(10));
		//Ver que el cliente aun no se ha insertado
		assertEquals(0, cliente.getIdCliente());
		//Cojer la tienda con el id de la base de datos directamente
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		Tienda tienda = tiendas.get(0);	
		
		//Crear la venta
		Venta venta = new Venta(new Date(10), true, (float)10.5);
		//ver que la venta aun no se ha insertado
		assertEquals(0, venta.getIdVenta());
		
		//Unir todas las dependencias en los objetos java
		cliente.getVentas().add(venta);
		venta.setCliente(cliente);
		
		tienda.getVentas().add(venta);
		venta.setTienda(tienda);
		
		//guardar el cliente, deberia guardarse lo otro
		clienteService.save(cliente);
		int id = cliente.getIdCliente();
		int idVenta = cliente.getVentas().get(0).getIdVenta();
		System.out.println("idCliente = "+ id);
		System.out.println("idVenta = " + idVenta);
		
		//comprobar que ha insertado lo otro
		assertThat(cliente.getIdCliente(), not(0));
		assertThat(tienda.getIdTienda(), not(0));
		assertThat(venta.getIdVenta(), not(0));
		
		//Eliminar el cliente
		clienteService.delete(cliente);
		 
        // Now we can't read it back, as expected
        Cliente cliente2 = clienteService.getInitialize(id);
        assertNull(cliente2);
        
        //Comprobar que la venta se ha eliminado
        Venta venta2 = ventaService.getInitialize(idVenta);
        assertNull(venta2);
        
	}
	
	
}