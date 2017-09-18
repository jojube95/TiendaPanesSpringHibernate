package com.joan.tiendapanes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joan.tiendapanes.dao.VentaDAO;
import com.joan.tiendapanes.entity.Venta;

@Service
public class VentaService {
	
	//need to inject the customer dao
	@Autowired
	private VentaDAO ventaDAO;
	
	@Transactional
	public List<Venta> get(){
		return ventaDAO.get();
	}
	
	@Transactional
	public List<Venta> getInitialize(){
		return ventaDAO.getInitialize();
	}
	
	@Transactional
	public Venta getInitialize(int id){
		return ventaDAO.getInitialize(id);
	}
	
	@Transactional
	public Venta get(int id){
		return ventaDAO.get(id);
	}
	
	@Transactional
	public <T> void save(T entity) {
		ventaDAO.save(entity);
	}

	@Transactional
	public Venta update(Venta venta) {
		return (Venta) ventaDAO.update(venta);
	}

	@Transactional
	public void delete(Venta venta) {
		ventaDAO.delete(venta);
	}
}
