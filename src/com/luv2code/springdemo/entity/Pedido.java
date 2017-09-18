package com.luv2code.springdemo.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private int id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "precio")
	private float precio;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.pedido", cascade = CascadeType.ALL)
	private List<PanFabricaPedido> panFabricaPedidos = new ArrayList<PanFabricaPedido>();
		
	@ManyToOne()
	@JoinColumn(name = "idTienda")
	private Tienda tienda;
	

	public Pedido() {
	}

	public Pedido(Date fecha, float precio) {
		this.fecha = fecha;
		this.precio = precio;
	}
	
	

	public Pedido(Date fecha, float precio, List<PanFabricaPedido> panFabricaPedidos) {
		this.fecha = fecha;
		this.precio = precio;
		this.panFabricaPedidos = panFabricaPedidos;
	}



	public Pedido(Date fecha, float precio, List<PanFabricaPedido> panFabricaPedidos, Tienda tienda) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.panFabricaPedidos = panFabricaPedidos;
		this.tienda = tienda;
	}

	public int getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public float getPrecio() {
		return precio;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	

	@Override
	public String toString() {
		
		return "Pedido [id=" + id + ", fecha=" + fecha + ", precio=" + precio + ", panesFabrica=" + panFabricaPedidos
				+ "]";
	}

	public List<PanFabricaPedido> getPanFabricaPedidos() {
		return panFabricaPedidos;
	}

	public void setPanFabricaPedidos(List<PanFabricaPedido> panFabricaPedidos) {
		this.panFabricaPedidos = panFabricaPedidos;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	

	
	
	
	
}
