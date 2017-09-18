package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.PanTienda;


@Repository
public class PanTiendaDAO {
	@Autowired
	private SessionFactory sessionFactory;
		
	
	public PanTienda get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		PanTienda panTienda = currentSession.get(PanTienda.class, id);
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
		//for(PanFabricaPedido panFabricaPedido : pedido.getPanFabricaPedidos()){
			//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		//}
		// return the results		
		return panTienda;
	}
	
	public List<PanTienda> get(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<PanTienda> theQuery = currentSession.createQuery("from PanTienda", PanTienda.class);
		
		// execute query and get result list
		List<PanTienda> panesFabrica = theQuery.getResultList();
				
		// return the results		
		return panesFabrica;
	}

	public <T> Object save(T entity) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(entity);
		
		return entity;
	}

	public <T> Object update(T entity) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		 
		currentSession.merge(entity);
		 		 
		return entity;
		 
	}

	public <T> void delete(T entity) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(entity);
		
		 
	 }

}

