package com.joan.tiendapanes.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joan.tiendapanes.dao.PanFabricaDAO;
import com.joan.tiendapanes.entity.PanFabrica;

@Service
public class PanFabricaService {

	//need to inject the customer dao
	@Autowired
	private PanFabricaDAO panFabricaDAO;
			
	@Transactional
	public List<PanFabrica> get() {
		return panFabricaDAO.get();
	}

	@Transactional
	public PanFabrica get(int id) {
		return panFabricaDAO.get(id);
	}
	
	@Transactional
	public void save(PanFabrica panFabrica) {
		panFabricaDAO.save(panFabrica);
	}

	@Transactional
	public PanFabrica update(PanFabrica panFabrica){
		return (PanFabrica) panFabricaDAO.update(panFabrica);
	}
	
	@Transactional
	public void delete(PanFabrica panFabrica) {
		panFabricaDAO.delete(panFabrica);
	}

}


