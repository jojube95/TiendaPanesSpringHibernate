package com.joan.tiendapanes.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.joan.tiendapanes.entity.PanTienda;
import com.joan.tiendapanes.entity.Pedido;
import com.joan.tiendapanes.entity.Tienda;
import com.joan.tiendapanes.entity.Venta;
import com.joan.tiendapanes.service.PanTiendaService;
import com.joan.tiendapanes.service.PedidoService;
import com.joan.tiendapanes.service.TiendaService;
import com.joan.tiendapanes.service.VentaService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
@EnableTransactionManagement
public class TiendaDAOTest {

	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private PanTiendaService panTiendaService;
	
	final String localidad = "LOCALIDAD TEST";
	final String nombre = "NOMBRE TEST";
	final String contrasenya = "CONTRASENYA TEST";
	
	@Test
	@Transactional
	@Rollback(true)
	public void testEscrituraSoloTienda(){
		//Crear la tienda
		Tienda tienda = new Tienda(localidad, nombre, contrasenya);
		//ver que la venta aun no se ha insertado
		assertEquals(0, tienda.getIdTienda());
		
		//guardar la tienda
		tiendaService.save(tienda);
				
		//comprobar que ha insertado
		assertThat(tienda.getIdTienda(), not(0));
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaTienda() {
		//Crear la tienda
		Tienda tienda = new Tienda(localidad, nombre, contrasenya);
		//ver que la venta aun no se ha insertado
		assertEquals(0, tienda.getIdTienda());
		
		//guardar la tienda
		tiendaService.save(tienda);
		int idTienda = tienda.getIdTienda();
		
		//comprobar que ha
		assertThat(tienda.getIdTienda(), not(0));
		
		
		//Leer y comprobar
		Tienda tienda2 = tiendaService.getInitialize(idTienda);
		
		assertEquals(tienda2.getLocalidad(), localidad);
		assertEquals(tienda2.getNombre(), nombre);
		assertEquals(tienda2.getContrasenya(), contrasenya);
		        
    }
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloTiendas(){
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		assertTrue(tiendas.size() > 0);
		
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaSoloTiendasInitialize(){
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		assertTrue(tiendas.size() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaTiendaVentaPedidoPanes(){
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		assertTrue(tiendas.size() > 0);
		assertNotNull(tiendas.get(0).getVentas());
		assertNotNull(tiendas.get(0).getPedidos());
		assertTrue(tiendas.get(0).getPanesTienda().size() > 0);
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaTiendaVentaPedidoPanesInitialize(){
		ArrayList<Tienda> tiendas = (ArrayList<Tienda>) tiendaService.getInitialize();
		assertTrue(tiendas.size() > 0);
		assertNotNull(tiendas.get(0).getVentas());
		assertNotNull(tiendas.get(0).getPedidos());
		assertTrue(tiendas.get(0).getPanesTienda().size() > 0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateSoloVenta(){
		final String localidad2 = "LOCALIDAD TEST 2";
		final String nombre2 = "NOMBRE TEST 2";
		final String contrasenya2 = "CONTRASENYA TEST 2";
		//Crear la venta
		Tienda tienda = new Tienda(localidad, nombre, contrasenya);
		//ver que la venta aun no se ha insertado
		assertEquals(0, tienda.getIdTienda());
		
		//guardar la venta
		tiendaService.save(tienda);
		int idTienda = tienda.getIdTienda();
		
		//comprobar que ha insertado lo otro
		assertThat(tienda.getIdTienda(), not(0));
		
        
        tienda.setLocalidad(localidad2);
        tienda.setNombre(nombre2);
        tienda.setContrasenya(contrasenya2);
        
        tiendaService.update(tienda);
        
        Tienda tienda2 = tiendaService.getInitialize(idTienda);
        assertEquals(tienda2.getLocalidad(), localidad2);
        assertEquals(tienda2.getNombre(), nombre2);
        assertEquals(tienda2.getContrasenya(), contrasenya2);
        
        
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteTienda(){
		//Cojer la unica tienda de la base de datos de prueba
		Tienda tienda = tiendaService.getInitialize().get(0);
		int idTienda = tienda.getIdTienda();
		int idVenta = tienda.getVentas().get(0).getIdVenta();
		int idPedido = tienda.getPedidos().get(0).getId();
		int idPan = tienda.getPanesTienda().get(0).getIdPanTienda();
		//Eliminar la tienda
		tiendaService.delete(tienda);
		 
        //Comprobar que la tienda se ha eliminado
        Tienda tienda2 = tiendaService.getInitialize(idTienda);
        assertNull(tienda2);
        //Comprobar que panes, pedidos y ventas se han eliminado
        Venta venta = ventaService.getInitialize(idVenta);
        assertNull(venta);
        
        Pedido pedido = pedidoService.getInitialize(idPedido);
        assertNull(pedido);
        
        PanTienda panTienda= panTiendaService.get(idPan);
        assertNull(panTienda);
        
        
        
	}
	
	
}
