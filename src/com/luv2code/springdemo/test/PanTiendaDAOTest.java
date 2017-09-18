package com.luv2code.springdemo.test;

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
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Pan;
import com.luv2code.springdemo.entity.PanFabrica;
import com.luv2code.springdemo.entity.PanTienda;
import com.luv2code.springdemo.entity.Tienda;
import com.luv2code.springdemo.entity.Venta;
import com.luv2code.springdemo.service.PanFabricaService;
import com.luv2code.springdemo.service.PanTiendaService;
import com.luv2code.springdemo.service.TiendaService;
import com.luv2code.springdemo.service.VentaService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/test-spring-mvc-crud-demo-servlet.xml"})
public class PanTiendaDAOTest {
	
	@Autowired
	private PanFabricaService panFabricaService;
	
	@Autowired
	private VentaService ventaservice;
	
	@Autowired
	private PanTiendaService panTiendaService;
	
	@Autowired
	private TiendaService tiendaService;
	
	
	final String tipo = "TIPO TEST";
	final String nombre = "NOMBRE TEST";
	final int cantidad = 69;
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituaPanTienda() {
		//Cojer una tienda
		Tienda tienda = tiendaService.getInitialize().get(0);
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		//Cojer un panFabrica de la base de datos
		PanFabrica panFabrica = panFabricaService.get().get(0);
		//Crear el panTienda
		PanTienda panTienda = new PanTienda(pan, cantidad, tienda, panFabrica);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panTienda.getIdPanTienda());
		
		//guardar el pan
		panTiendaService.save(panTienda);
				
		//comprobar que ha insertado
		assertThat(panTienda.getIdPanTienda(), not(0));
        
       
    }
	
	@Test
	@Transactional
	@Rollback(true)
    public void testEscrituraYLecturaPanTienda() {
		//Cojer una tienda
		Tienda tienda = tiendaService.getInitialize().get(0);
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		//Cojer un panFabrica de la base de datos
		PanFabrica panFabrica = panFabricaService.get().get(0);
		//Crear el panTienda
		PanTienda panTienda = new PanTienda(pan, cantidad, tienda, panFabrica);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panTienda.getIdPanTienda());
		
		//guardar el pan
		panTiendaService.save(panTienda);
		int idPanTienda = panTienda.getIdPanTienda();	
		//comprobar que ha insertado
		assertThat(panTienda.getIdPanTienda(), not(0));
		
		
		//Leer y comprobar
		PanTienda panTienda2 = panTiendaService.get(idPanTienda);
		
		assertEquals(panTienda2.getPan().getNombre(), nombre);
		assertEquals(panTienda2.getPan().getTipo(), tipo);
		assertEquals(panTienda2.getCant(), cantidad);
		
		        
    }
	
	@Test
	@Transactional
	@Rollback(true)
	public void testLecturaPanesTienda(){
		ArrayList<PanTienda> panesTienda = (ArrayList<PanTienda>) panTiendaService.get();
		assertTrue(panesTienda.size() > 0);
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdatePanFabrica(){
		final String tipo2 = "TIPO TEST 2";
		final String nombre2 = "NOMBRE TEST 2";
		final int cantidad2 = 13;
		
		//Cojer una tienda
		Tienda tienda = tiendaService.getInitialize().get(0);
		//Crear el pan
		Pan pan = new Pan(tipo, nombre, (float)60.60);
		//Cojer un panFabrica de la base de datos
		PanFabrica panFabrica = panFabricaService.get().get(0);
		//Crear el panTienda
		PanTienda panTienda = new PanTienda(pan, cantidad, tienda, panFabrica);
		
		//ver que el pan aun no se ha insertado
		assertEquals(0, panTienda.getIdPanTienda());
		
		//guardar el pan
		panTiendaService.save(panTienda);
		int idPanTienda = panTienda.getIdPanTienda();
		//comprobar que ha insertado
		assertThat(panTienda.getIdPanTienda(), not(0));
		
		//setter en el pan
		panTienda.getPan().setTipo(tipo2);
		panTienda.getPan().setNombre(nombre2);
        panTienda.setCant(cantidad2);
        
        panTiendaService.update(panTienda);
        
        PanTienda panTienda2 = panTiendaService.get(idPanTienda);
        assertEquals(panTienda2.getPan().getNombre(), nombre2);
        assertEquals(panTienda2.getPan().getTipo(), tipo2);
        assertEquals(panTienda2.getCant(), cantidad2);
        
        
        
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeletePanTienda(){
		//Cojer un panTienda de la base de datos
		PanTienda panTienda = panTiendaService.get().get(0);
		int idPanTienda = panTienda.getIdPanTienda();
		
		//Cojer la venta de la base de datos
		Venta venta = ventaservice.get().get(0);
		int idVenta = venta.getIdVenta();
		
		//Cojer el panFabrica de la base de datos
		PanFabrica panFabrica = panFabricaService.get().get(0);
		int idPanFabrica = panFabrica.getIdPan();
		
		//Eliminar el panTienda
		panTiendaService.delete(panTienda);
		 
        //Comprobar que el panTienda se ha eliminado
        PanTienda panTienda2 = panTiendaService.get(idPanTienda);
        assertNull(panTienda2);
        
        //Comprobar que no se ha eliminado el panFabrica
        PanFabrica panFabrica2 = panFabricaService.get(idPanFabrica);
        assertNotNull(panFabrica2);
        
        //Comprobar que no se ha eliminado la venta
        Venta venta2 = ventaservice.get(idVenta);
        assertNotNull(venta2);
        
        
        
	}

}
