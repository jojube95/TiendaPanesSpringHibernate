package com.joan.tiendapanes.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

@Entity
@Table(name = "panfabrica")
public class PanFabrica{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPan")
	private int idPan;
	
	@Embedded
	private Pan pan;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.panFabrica", cascade = CascadeType.ALL)
	private List<PanFabricaPedido> panFabricaPedidos = new ArrayList<PanFabricaPedido>();
	
	@OneToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "idPan")
	private List<PanTienda> panTiendas = new ArrayList<>();
	

	public PanFabrica(){
		
	}
	
	public PanFabrica(Pan pan) {
		this.pan = pan;
	}


	
	public PanFabrica(Pan pan, List<PanTienda> panTiendas) {
		this.pan = pan;
		this.panTiendas = panTiendas;
	}
		
	public PanFabrica(Pan pan, List<PanFabricaPedido> panFabricaPedidos, List<PanTienda> panTiendas) {
		super();
		this.pan = pan;
		this.panFabricaPedidos = panFabricaPedidos;
		this.panTiendas = panTiendas;
	}

	public float calcularPrecioTotal(Pan pan, int cant){
		return pan.getPrecio() * cant;
	}



	public int getIdPan() {
		return idPan;
	}



	public Pan getPan() {
		return pan;
	}



	


	public void setIdPan(int idPan) {
		this.idPan = idPan;
	}



	public void setPan(Pan pan) {
		this.pan = pan;
	}



	public List<PanFabricaPedido> getPanFabricaPedidos() {
		return panFabricaPedidos;
	}



	public void setPanFabricaPedidos(List<PanFabricaPedido> panFabricaPedidos) {
		this.panFabricaPedidos = panFabricaPedidos;
	}

	public List<PanTienda> getPanTiendas() {
		return panTiendas;
	}



	public void setPanTiendas(List<PanTienda> panTiendas) {
		this.panTiendas = panTiendas;
	}

	@Override
	public String toString() {
		return "PanFabrica [idPan=" + idPan + ", pan=" + pan.toString() + "]";
	}



	



	



	


	
}
