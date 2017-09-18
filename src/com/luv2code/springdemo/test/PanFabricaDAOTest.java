package com.luv2code.springdemo.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Pan;
import com.luv2code.springdemo.entity.PanFabrica;
import com.luv2code.springdemo.entity.PanTienda;
import com.luv2code.springdemo.entity.Pedido;
import com.luv2code.springdemo.service.PanFabricaService;
import com.luv2code.springdemo.service.PanTiendaService;
import com.luv2code.springdemo.service.PedidoService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
public class PanFabricaDAOTest {
	
	@Autowired
	private PanFabricaService panFabricaService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PanTiendaService panTiendaService;
	
	
	
	final String tipo = "TIPO TEST";
	final String nombre = "NOMBRE TEST";
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituaPanFabrica() {
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		PanFabrica panFabrica = new PanFabrica(pan);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panFabrica.getIdPan());
		
		//guardar el pan
		panFabricaService.save(panFabrica);
				
		//comprobar que ha insertado
		assertThat(panFabrica.getIdPan(), not(0));
        
       
    }
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaPanFabrica() {
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		PanFabrica panFabrica = new PanFabrica(pan);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panFabrica.getIdPan());
		
		//guardar el pan
		panFabricaService.save(panFabrica);
		
		int idPan = panFabrica.getIdPan();
		//comprobar que ha insertado
		assertThat(panFabrica.getIdPan(), not(0));
		
		
		//Leer y comprobar
		PanFabrica panFabrica2 = panFabricaService.get(idPan);
		
		assertEquals(panFabrica2.getPan().getNombre(), nombre);
		assertEquals(panFabrica2.getPan().getTipo(), tipo);
		
		        
    }
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaPanesFabrica(){
		ArrayList<PanFabrica> panesFabrica = (ArrayList<PanFabrica>) panFabricaService.get();
		assertTrue(panesFabrica.size() > 0);
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdatePanFabrica(){
		final String tipo2 = "TIPO TEST 2";
		final String nombre2 = "NOMBRE TEST 2";
		
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		PanFabrica panFabrica = new PanFabrica(pan);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panFabrica.getIdPan());
		
		//guardar el pan
		panFabricaService.save(panFabrica);
		int idPan = panFabrica.getIdPan();
		//comprobar que ha insertado
		assertThat(panFabrica.getIdPan(), not(0));
		
		//setter en el pan
		panFabrica.getPan().setTipo(tipo2);
		panFabrica.getPan().setNombre(nombre2);
        
        panFabricaService.update(panFabrica);
        
        PanFabrica panFabrica2 = panFabricaService.get(idPan);
        assertEquals(panFabrica2.getPan().getNombre(), nombre2);
        assertEquals(panFabrica2.getPan().getTipo(), tipo2);
        
        
        
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeletePanFabrica(){
		//Cojer un panFabrica de la base de datos
		PanFabrica panFabrica = panFabricaService.get().get(0);
		int idPan = panFabrica.getIdPan();
		
		//Cojer el pedido de la base de datos de prueba
		Pedido pedido = pedidoService.get().get(0);
		int idPedido = pedido.getId();
		
		//Cojer el panTienda de la base de datos
		PanTienda panTienda = panTiendaService.get().get(0);
		int idPanTienda = panTienda.getIdPanTienda();
		
		//Eliminar el panFabrica
		panFabricaService.delete(panFabrica);
		 
        //Comprobar que el panFabrica se ha eliminado
        PanFabrica panFabrica2 = panFabricaService.get(idPan);
        assertNull(panFabrica2);
        
        //Comprobar que no se ha eliminado el panTienda
        PanTienda panTienda2 = panTiendaService.get(idPanTienda);
        assertNotNull(panTienda2);
        
        //Comprobar que no se ha eliminado el pan del pedido
        Pedido pedido2 = pedidoService.getInitialize(idPedido);
        assertTrue(pedido2.getPanFabricaPedidos().size() > 0);
        
        
        
	}

}
