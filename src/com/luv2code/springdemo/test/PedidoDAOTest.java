package com.luv2code.springdemo.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
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
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.PanFabrica;
import com.luv2code.springdemo.entity.PanFabricaPedido;
import com.luv2code.springdemo.entity.PanFabricaPedidoPK;
import com.luv2code.springdemo.entity.Pedido;
import com.luv2code.springdemo.entity.Tienda;
import com.luv2code.springdemo.service.PanFabricaService;
import com.luv2code.springdemo.service.PedidoService;
import com.luv2code.springdemo.service.TiendaService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
public class PedidoDAOTest {
	
	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private PanFabricaService panFabricaService;
	
	@Autowired
	private PedidoService pedidoService;
	
	Tienda tienda;
	PanFabrica panFabrica;
	
	
	@Before
	public void beforeTest() {
		this.tienda = tiendaService.getInitialize().get(0);
		this.panFabrica = panFabricaService.get().get(0);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testEscrituraPedido(){
		//Crear el pedido
		Pedido pedido = new Pedido(new Date(10), (float)69.69);
		//ver que el pedido aun no se ha insertado
		assertEquals(0, pedido.getId());
		
		//Añadirle los panes y la tienda
		PanFabricaPedidoPK panFabricaPedidoPK = new PanFabricaPedidoPK();
		panFabricaPedidoPK.setPanFabrica(panFabrica);
		panFabricaPedidoPK.setPedido(pedido);
		
		PanFabricaPedido panFabricaPedido = new PanFabricaPedido();
		panFabricaPedido.setId(panFabricaPedidoPK);
		panFabricaPedido.setCant(11);
		
		pedido.getPanFabricaPedidos().add(panFabricaPedido);
		
		pedido.setTienda(tienda);
		//Asignarle una tienda
		//tienda.getPedidos().add(pedido);
		
		
		//guardar el pedido
		pedidoService.save(pedido);
				
		//comprobar que se ha insertado
		assertThat(pedido.getId(), not(0));
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaPedido() {
		//Crear el pedido
		Pedido pedido = new Pedido(new Date(10), (float)69.69);
		//ver que el pedido aun no se ha insertado
		assertEquals(0, pedido.getId());
		
		//Añadirle los panes
		PanFabricaPedidoPK panFabricaPedidoPK = new PanFabricaPedidoPK();
		panFabricaPedidoPK.setPanFabrica(panFabrica);
		panFabricaPedidoPK.setPedido(pedido);
		
		PanFabricaPedido panFabricaPedido = new PanFabricaPedido();
		panFabricaPedido.setId(panFabricaPedidoPK);
		panFabricaPedido.setCant(11);
		
		pedido.getPanFabricaPedidos().add(panFabricaPedido);
		
		//Añadirle una tienda
		pedido.setTienda(tienda);
		//Asignarle una tienda
		//tienda.getPedidos().add(pedido);
		
		
		//guardar el pedido
		pedidoService.save(pedido);
		int idPedido = pedido.getId();
				
		//comprobar que se ha insertado
		assertThat(pedido.getId(), not(0));
		
		
		//Leer y comprobar
		Pedido pedido2 = pedidoService.get(idPedido);
		
		assertEquals(pedido2.getPanFabricaPedidos().get(0).getCant(), 11);
		assertTrue(pedido2.getPanFabricaPedidos().size() > 0);
		        
    }
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaPedido(){
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>) pedidoService.get();
		assertTrue(pedidos.size() > 0);
		assertTrue(pedidos.get(0).getPanFabricaPedidos().size() > 0);
		
		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdatePedido(){
		final int cant2 = 16;
		//Crear el pedido
		Pedido pedido = new Pedido(new Date(10), (float)69.69);
		//ver que el pedido aun no se ha insertado
		assertEquals(0, pedido.getId());
		
		//Añadirle los panes
		PanFabricaPedidoPK panFabricaPedidoPK = new PanFabricaPedidoPK();
		panFabricaPedidoPK.setPanFabrica(panFabrica);
		panFabricaPedidoPK.setPedido(pedido);
		
		PanFabricaPedido panFabricaPedido = new PanFabricaPedido();
		panFabricaPedido.setId(panFabricaPedidoPK);
		panFabricaPedido.setCant(11);
		
		pedido.getPanFabricaPedidos().add(panFabricaPedido);
		
		//aladirle una tienda
		
		pedido.setTienda(tienda);
		//Asignarle una tienda
		//tienda.getPedidos().add(pedido);
		
		
		//guardar el pedido
		pedidoService.save(pedido);
		int idPedido = pedido.getId();
		//comprobar que se ha insertado
		assertThat(pedido.getId(), not(0));
		
		//set al pedido
		pedido.getPanFabricaPedidos().get(0).setCant(cant2);
		
		//update
		pedidoService.update(pedido);
		
		//comprobar la cantidad
		Pedido pedido2 = pedidoService.get(idPedido);
		assertEquals(pedido2.getPanFabricaPedidos().get(0).getCant(), cant2);
        
        
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeletePedido(){
		//Cojer el pedido de la base de datos
		Pedido pedido = pedidoService.get().get(0);
		int idPedido = pedido.getId();
		
		int idPan = pedido.getPanFabricaPedidos().get(0).getId().getPanFabrica().getIdPan();
		
		Tienda tienda = tiendaService.getInitialize().get(0);
		int idTienda = tienda.getIdTienda();
		
		//Eliminar el pedido
		pedidoService.delete(pedido);
        //Comprobar que el pedido se ha eliminado
		Pedido pedido2 = pedidoService.getInitialize(idPedido);
        assertNull(pedido2);	
        
		//Comprobar que la tienda no se ha eliminado
		Tienda tienda2 = tiendaService.getInitialize(idTienda);
		assertNotNull(tienda2);
		
		//Comporbar que el panFabrica no se ha eliminado
		PanFabrica panFabrica = panFabricaService.get(idPan);
		assertNotNull(panFabrica);
		
               
        
	}
	

}
