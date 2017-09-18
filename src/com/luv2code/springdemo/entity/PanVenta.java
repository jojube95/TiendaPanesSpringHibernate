package com.luv2code.springdemo.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "panventa")
@AssociationOverrides({
@AssociationOverride(name = "id.panTienda", joinColumns = @JoinColumn(name = "idPantienda")),
@AssociationOverride(name = "id.venta", joinColumns = @JoinColumn(name = "idVenta")) })
public class PanVenta {

	@EmbeddedId
	private PanVentaPK id = new PanVentaPK();
	
	@Column(name = "cantidad")
	private int cant;

	public PanVentaPK getId() {
		return id;
	}

	public int getCant() {
		return cant;
	}

	public void setId(PanVentaPK id) {
		this.id = id;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public PanTienda getPanTienda(){
		return getId().getPanTienda();
	}
	
	public void setPanTienda(PanTienda panTienda){
		getId().setPanTienda(panTienda);
	}
	
	public Venta getVenta(){
		return getId().getVenta();
	}
	
	public void setVenta(Venta venta){
		getId().setVenta(venta);
	}

	
	
}
