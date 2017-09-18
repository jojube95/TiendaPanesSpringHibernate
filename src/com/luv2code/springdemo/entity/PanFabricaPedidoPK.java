package com.luv2code.springdemo.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PanFabricaPedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
	private PanFabrica panFabrica;
	
	@ManyToOne
	private Pedido pedido;

	public PanFabrica getPanFabrica() {
		return panFabrica;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPanFabrica(PanFabrica panFabrica) {
		this.panFabrica = panFabrica;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
	

}
