package com.joan.tiendapanes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tienda")
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTienda")
	private int idTienda;
	
	@Column(name = "localidad")
	private String localidad;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "contrasenya")
	private String contrasenya;
	
	@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> ventas = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idTienda")
    private List<Pedido> pedidos = new ArrayList<>();

	@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PanTienda> panesTienda = new ArrayList<>();
	
	public Tienda() {
	}
	
	public Tienda(String localidad, String nombre, String contrasenya) {
		this.localidad = localidad;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
	}

	
	public Tienda(String localidad, String nombre, String contrasenya, List<Venta> ventas) {
		this.localidad = localidad;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.ventas = ventas;
	}


	public Tienda(int idTienda, String localidad, String nombre, String contrasenya, List<Pedido> pedidos) {
		this.idTienda = idTienda;
		this.localidad = localidad;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.pedidos = pedidos;
	}


	public Tienda(String localidad, String nombre, String contrasenya, List<Venta> ventas, List<Pedido> pedidos) {
		this.localidad = localidad;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.ventas = ventas;
		this.pedidos = pedidos;
	}

	

	public Tienda(String localidad, String nombre, String contrasenya, List<Venta> ventas, List<Pedido> pedidos,
			List<PanTienda> panesTienda) {
		this.localidad = localidad;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.ventas = ventas;
		this.pedidos = pedidos;
		this.panesTienda = panesTienda;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
		
	@Override
	public String toString() {
		return "Tienda [idTienda=" + idTienda + ", localidad=" + localidad + ", nombre=" + nombre + ", contrasenya="
				+ contrasenya + "]";
	}

	public List<PanTienda> getPanesTienda() {
		return panesTienda;
	}

	public void setPanesTienda(List<PanTienda> panesTienda) {
		this.panesTienda = panesTienda;
	}

	
	
}
