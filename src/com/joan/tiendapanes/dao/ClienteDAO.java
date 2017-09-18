package com.joan.tiendapanes.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joan.tiendapanes.entity.Cliente;
import com.joan.tiendapanes.entity.Venta;

@Repository
public class ClienteDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//Solucion con join fetch
	public Cliente get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Query query = currentSession.createQuery("from Cliente p join fetch p.ventas where p.idCliente = :clienteId");
		query.setParameter("clienteId", id);
		//Pedido pedido = currentSession.get(Pedido.class, id);
		Cliente cliente = (Cliente) query.getSingleResult();
		
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		
		return cliente;
	}
	
	//Solucion con Hibernate.initialize
	public Cliente getInitialize(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		Cliente cliente = currentSession.get(Cliente.class, id);
		
		try{
			Hibernate.initialize(cliente.getVentas());
			for(Venta venta : cliente.getVentas()) {
				Hibernate.initialize(venta);
			}
		}catch (NullPointerException e) {
			return null;
		}
		
		return cliente;
	}
	
	//Solucion con Hibernate.initialize
	public List<Cliente> getInitialize(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Cliente> theQuery = currentSession.createQuery("from Cliente", Cliente.class);
		
		// execute query and get result list
		List<Cliente> clientes = theQuery.getResultList();
		for(Cliente cliente : clientes){
			Hibernate.initialize(cliente.getVentas());
		}
		// return the results		
		return clientes;
	}
	
	//Solucion con join fetch, da resultados duplicados por el List
	public List<Cliente> get(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<Cliente> theQuery = currentSession.createQuery("from Cliente p join fetch p.ventas", Cliente.class);
		
		// execute query and get result list
		List<Cliente> clientes = theQuery.getResultList();
		
		// return the results	
		return clientes;
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
