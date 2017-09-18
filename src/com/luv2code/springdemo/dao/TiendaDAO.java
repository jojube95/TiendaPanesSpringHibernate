package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Tienda;

@Repository
public class TiendaDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//Solucion con join fetch
	public Tienda get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query query = currentSession.createQuery("from Tienda p join fetch p.ventas where p.idTienda = :tiendaId");
		query.setParameter("tiendaId", id);
		//Pedido pedido = currentSession.get(Pedido.class, id);
		Tienda tienda = (Tienda) query.getSingleResult();
		
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		
		return tienda;
	}
	
	//Solucion con Hibernate.initialize
	public Tienda getInitialize(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Tienda tienda = currentSession.get(Tienda.class, id);
		
		try{
			Hibernate.initialize(tienda.getVentas());
			Hibernate.initialize(tienda.getPanesTienda());
			Hibernate.initialize(tienda.getPedidos());
			
		}catch (NullPointerException e) {
			return null;
		}
		
			
		
		return tienda;
	}
	
	//Solucion con Hibernate.initialize
	public List<Tienda> getInitialize(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Tienda> theQuery = currentSession.createQuery("from Tienda", Tienda.class);
		
		// execute query and get result list
		List<Tienda> tiendas = theQuery.getResultList();
		for(Tienda tienda : tiendas){
			Hibernate.initialize(tienda.getVentas());
		}
		// return the results		
		return tiendas;
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
