package com.luv2code.springdemo.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Venta;


@Repository
public class VentaDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//Solucion con join fetch
	public Venta get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query query = currentSession.createQuery("from Venta p join fetch p.panVentas where p.id = :ventaId");
		query.setParameter("ventaId", id);
		//Pedido pedido = currentSession.get(Pedido.class, id);
		Venta venta = (Venta) query.getSingleResult();
		
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		
		return venta;
	}
	
	//Solucion con Hibernate.initialize
	public Venta getInitialize(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Venta venta = currentSession.get(Venta.class, id);
		
		try{
			Hibernate.initialize(venta.getPanVentas());
		}catch (NullPointerException e) {
			return null;
		}
			
		
		return venta;
	}
	
	//Solucion con Hibernate.initialize
	public List<Venta> getInitialize(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Venta> theQuery = currentSession.createQuery("from Venta", Venta.class);
		
		// execute query and get result list
		List<Venta> ventas = theQuery.getResultList();
		for(Venta venta : ventas){
			Hibernate.initialize(venta.getPanVentas());
		}
		// return the results		
		return ventas;
	}
	
	//Solucion con join fetch, da resultados duplicados por el List
	public List<Venta> get(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Venta> theQuery = currentSession.createQuery("from Venta p join fetch p.panVentas", Venta.class);
		
		// execute query and get result list
		List<Venta> ventas = theQuery.getResultList();
		
		// return the results	
		return ventas;
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