package com.luv2code.springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.TiendaDAO;
import com.luv2code.springdemo.entity.Tienda;

@Service
public class TiendaService {

	//need to inject the customer dao
	@Autowired
	private TiendaDAO tiendaDAO;
	
	
	@Transactional
	public List<Tienda> getInitialize(){
		return tiendaDAO.getInitialize();
	}
	
	@Transactional
	public Tienda getInitialize(int id){
		return tiendaDAO.getInitialize(id);
	}
	
	@Transactional
	public Tienda get(int id){
		return tiendaDAO.get(id);
	}
	
	@Transactional
	public <T> void save(T entity) {
		tiendaDAO.save(entity);
	}

	@Transactional
	public Tienda update(Tienda tienda) {
		return (Tienda) tiendaDAO.update(tienda);
	}

	@Transactional
	public void delete(Tienda tienda) {
		tiendaDAO.delete(tienda);
	}
}
