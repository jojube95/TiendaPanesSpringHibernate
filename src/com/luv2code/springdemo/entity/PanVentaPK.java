package com.luv2code.springdemo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PanVentaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	private PanTienda panTienda;
	
	@ManyToOne
	private Venta venta;

	public PanTienda getPanTienda() {
		return panTienda;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setPanTienda(PanTienda panTienda) {
		this.panTienda = panTienda;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	

}
