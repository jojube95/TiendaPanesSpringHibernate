package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ClienteDAO;
import com.luv2code.springdemo.entity.Cliente;

@Service
public class ClienteService {

	//need to inject the customer dao
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Transactional
	public List<Cliente> get(){
		return clienteDAO.get();
	}
	
	@Transactional
	public List<Cliente> getInitialize(){
		return clienteDAO.getInitialize();
	}
	
	@Transactional
	public Cliente getInitialize(int id){
		return clienteDAO.getInitialize(id);
	}
	
	@Transactional
	public Cliente get(int id){
		return clienteDAO.get(id);
	}
	
	@Transactional
	public <T> void save(T entity) {
		clienteDAO.save(entity);
	}

	@Transactional
	public Cliente update(Cliente cliente) {
		return (Cliente) clienteDAO.update(cliente);
	}

	@Transactional
	public void delete(Cliente cliente) {
		clienteDAO.delete(cliente);
	}
}
