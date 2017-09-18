package com.luv2code.springdemo.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "panfabricapedido")
@AssociationOverrides({
@AssociationOverride(name = "id.panFabrica", joinColumns = @JoinColumn(name = "idPan")),
@AssociationOverride(name = "id.pedido", joinColumns = @JoinColumn(name = "idPedido")) })
public class PanFabricaPedido {

	@EmbeddedId
	private PanFabricaPedidoPK id = new PanFabricaPedidoPK();
	
	@Column(name ="cantidad")
	private int cant;

	public PanFabricaPedidoPK getId() {
		return id;
	}

	public int getCant() {
		return cant;
	}

	public void setId(PanFabricaPedidoPK id) {
		this.id = id;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public PanFabrica getPanFabrica(){
		return getId().getPanFabrica();
	}
	
	public void setPanFabrica(PanFabrica panFabrica){
		getId().setPanFabrica(panFabrica);
	}
	
	public Pedido getPedido(){
		return getId().getPedido();
	}
	
	public void setPedido(Pedido pedido){
		getId().setPedido(pedido);
	}
	
	
	
}
