package com.joan.tiendapanes.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joan.tiendapanes.entity.PanFabrica;


@Repository
public class PanFabricaDAO {
	@Autowired
	private SessionFactory sessionFactory;
		
	
	public PanFabrica get(int id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		PanFabrica panFabrica = currentSession.get(PanFabrica.class, id);
		//Hibernate.initialize(pedido.getPanFabricaPedidos());
		//for(PanFabricaPedido panFabricaPedido : pedido.getPanFabricaPedidos()){
			//Hibernate.initialize(pedido.getPanFabricaPedidos());
			
		//}
		// return the results		
		return panFabrica;
	}
	
	public List<PanFabrica> get(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query..sort by the last name
		Query<PanFabrica> theQuery = currentSession.createQuery("from PanFabrica", PanFabrica.class);
		
		// execute query and get result list
		List<PanFabrica> panesFabrica = theQuery.getResultList();
				
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

