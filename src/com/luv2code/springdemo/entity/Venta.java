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
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private int idVenta;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "online")
	private boolean online;
	
	@Column(name = "precio")
	private float precio;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.venta", cascade = CascadeType.ALL)
	private List<PanVenta> panVentas = new ArrayList<PanVenta>();

	@ManyToOne()
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name = "idTienda")
	private Tienda tienda;
	
	public Venta() {
	}
	
	public Venta(Date fecha, boolean online, float precio) {
		this.fecha = fecha;
		this.online = online;
		this.precio = precio;
	}

	
	
	public Venta(Date fecha, boolean online, float precio, List<PanVenta> panVentas) {
		super();
		this.fecha = fecha;
		this.online = online;
		this.precio = precio;
		this.panVentas = panVentas;
	}



	
	public Venta(Date fecha, boolean online, float precio, List<PanVenta> panVentas, Cliente cliente, Tienda tienda) {
		super();
		this.fecha = fecha;
		this.online = online;
		this.precio = precio;
		this.panVentas = panVentas;
		this.cliente = cliente;
		this.tienda = tienda;
	}

	
	public int getIdVenta() {
		return idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public boolean isOnline() {
		return online;
	}

	public float getPrecio() {
		return precio;
	}

	public List<PanVenta> getPanVentas() {
		return panVentas;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setPanVentas(List<PanVenta> panVentas) {
		this.panVentas = panVentas;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + ", online=" + online + ", precio=" + precio
				+ ", panVentas=" + panVentas + "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public void setPrecio() {
		for(PanVenta panVenta : this.panVentas) {
			this.precio += panVenta.getCant() *  panVenta.getPanTienda().getPan().getPrecio();
		}
		
	}
	
	
	
	
	
}
