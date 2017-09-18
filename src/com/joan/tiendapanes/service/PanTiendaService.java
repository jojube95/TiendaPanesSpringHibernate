package com.joan.tiendapanes.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joan.tiendapanes.dao.PanTiendaDAO;
import com.joan.tiendapanes.entity.PanTienda;


@Service
public class PanTiendaService {

	//need to inject the customer dao
	@Autowired
	private PanTiendaDAO panTiendaDAO;
			
	@Transactional
	public List<PanTienda> get() {
		return panTiendaDAO.get();
	}

	@Transactional
	public PanTienda get(int id) {
		return panTiendaDAO.get(id);
	}
	
	@Transactional
	public void save(PanTienda panTienda) {
		panTiendaDAO.save(panTienda);
	}

	@Transactional
	public PanTienda update(PanTienda panTienda){
		return (PanTienda) panTiendaDAO.update(panTienda);
	}
	
	@Transactional
	public void delete(PanTienda panTienda) {
		panTiendaDAO.delete(panTienda);
	}

}


