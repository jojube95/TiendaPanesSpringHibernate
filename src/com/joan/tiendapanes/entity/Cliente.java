package com.joan.tiendapanes.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "localidad")
	private String localidad;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasenya")
	private String contrasenya;
	
	@Column(name = "online")
	private boolean online;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> ventas = new ArrayList<>();

	public Cliente(){
		
	}
	public Cliente(String nombre, String localidad, Date fechaNacimiento) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
		this.online = false;
	}
	
	

	public Cliente(String nombre, String localidad, Date fechaNacimiento, String usuario, String contrasenya,
			boolean online) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.online = online;
	}



	public Cliente(String nombre, String localidad, Date fechaNacimiento, String usuario, String contrasenya,
			boolean online, List<Venta> ventas) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.online = online;
		this.ventas = ventas;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public boolean isOnline() {
		return online;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", localidad=" + localidad
				+ ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario + ", contrasenya=" + contrasenya
				+ ", online=" + online + "]";
	}
	
	
	
}
