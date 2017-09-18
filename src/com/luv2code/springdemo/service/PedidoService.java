package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.PedidoDAO;
import com.luv2code.springdemo.entity.Pedido;

@Service
public class PedidoService {
	
	//need to inject the customer dao
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Transactional
	public List<Pedido> get(){
		return pedidoDAO.get();
	}
	
	@Transactional
	public List<Pedido> getInitialize(){
		return pedidoDAO.getInitialize();
	}
	
	@Transactional
	public Pedido getInitialize(int id){
		return pedidoDAO.getInitialize(id);
	}
	
	@Transactional
	public Pedido get(int id){
		return pedidoDAO.get(id);
	}
	
	@Transactional
	public void save(Pedido pedido) {
		pedidoDAO.save(pedido);
	}

	@Transactional
	public Pedido update(Pedido pedido) {
		return (Pedido) pedidoDAO.update(pedido);
	}

	@Transactional
	public void delete(Pedido pedido) {
		pedidoDAO.delete(pedido);
	}
}
