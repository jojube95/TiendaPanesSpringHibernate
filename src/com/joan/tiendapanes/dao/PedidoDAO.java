package com.joan.tiendapanes.dao;

import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joan.tiendapanes.entity.Pedido;


@Repository
public class PedidoDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//Solucion con join fetch
	public Pedido get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query query = currentSession.createQuery("from Pedido p join fetch p.panFabricaPedidos where p.id = :pedidoId");
		query.setParameter("pedidoId", id);
		//Pedido pedido = currentSession.get(Pedido.class, id);
		Pedido pedido = (Pedido) query.getSingleResult();
		
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		
		return pedido;
	}
	
	//Solucion con Hibernate.initialize
	public Pedido getInitialize(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Pedido pedido = currentSession.get(Pedido.class, id);
		
		try {
			Hibernate.initialize(pedido.getPanFabricaPedidos());
		}
		catch (NullPointerException e) {
			return null;
		}
		
			
		
		return pedido;
	}
	
	//Solucion con Hibernate.initialize
	public List<Pedido> getInitialize(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Pedido> theQuery = currentSession.createQuery("from Pedido", Pedido.class);
		
		// execute query and get result list
		List<Pedido> pedidos = theQuery.getResultList();
		for(Pedido pedido : pedidos){
			Hibernate.initialize(pedido.getPanFabricaPedidos());
		}
		// return the results		
		return pedidos;
	}
	
	//Solucion con join fetch, da resultados duplicados por el List
	public List<Pedido> get(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Pedido> theQuery = currentSession.createQuery("from Pedido p join fetch p.panFabricaPedidos", Pedido.class);
		
		// execute query and get result list
		List<Pedido> pedidos = theQuery.getResultList();
		
		// return the results		
		return pedidos;
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