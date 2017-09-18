package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Pan {
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private float precio;
	
	
	public Pan() {
		
	}


	public Pan(String tipo, String nombre, float precio) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Pan [tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
}
