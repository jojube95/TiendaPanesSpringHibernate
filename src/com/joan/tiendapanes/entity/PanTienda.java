package com.joan.tiendapanes.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "pantienda")
public class PanTienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPantienda")
	private int idPanTienda;
	
	@Embedded
	private Pan pan;
	
	@Column(name = "cantidad")
	private int cant;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.panTienda", cascade = CascadeType.ALL)
	private List<PanVenta> panVentas = new ArrayList<PanVenta>();
	
	@ManyToOne()
	@JoinColumn(name = "idTienda")
	private Tienda tienda;
	
	@ManyToOne()
	@JoinColumn(name = "idPan")
	private PanFabrica panFabrica;
		
	
	
	public PanTienda(){
		
	}

	
	public PanTienda(Pan pan, int cant) {
		this.pan = pan;
		this.cant = cant;
		
	}

	
	public PanTienda(Pan pan, int cant, List<PanVenta> panVentas) {
		this.pan = pan;
		this.cant = cant;
		this.panVentas = panVentas;
		
	}


	public PanTienda(Pan pan, int cant, List<PanVenta> panVentas, Tienda tienda) {
		this.pan = pan;
		this.cant = cant;
		this.panVentas = panVentas;
		this.tienda = tienda;
		
	}

	
	public PanTienda(Pan pan, int cant, List<PanVenta> panVentas, Tienda tienda, PanFabrica panFabrica) {
		this.pan = pan;
		this.cant = cant;
		this.panVentas = panVentas;
		this.tienda = tienda;
		this.panFabrica = panFabrica;
		
	}
	
	


	public PanTienda(Pan pan, int cant, Tienda tienda, PanFabrica panFabrica) {
		this.pan = pan;
		this.cant = cant;
		this.tienda = tienda;
		this.panFabrica = panFabrica;
		
	}


	public float calcularPrecioTotal(Pan pan, int cant){
		return pan.getPrecio() * cant;
	}

	public int getIdPanTienda() {
		return idPanTienda;
	}

	public Pan getPan() {
		return pan;
	}

	public int getCant() {
		return cant;
	}

	public void setIdPanTienda(int idPanTienda) {
		this.idPanTienda = idPanTienda;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	@Override
	public String toString() {
		return "PanTienda [idPanTienda=" + idPanTienda + ", pan=" + pan + ", cant=" + cant + "]";
	}

	public List<PanVenta> getPanVentas() {
		return panVentas;
	}

	public void setPanVentas(List<PanVenta> panVentas) {
		this.panVentas = panVentas;
	}


	public Tienda getTienda() {
		return tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	public PanFabrica getPanFabrica() {
		return panFabrica;
	}


	public void setPanFabrica(PanFabrica panFabrica) {
		this.panFabrica = panFabrica;
	}
	
	/*public PanesTienda sumarPanes(PanesTienda panes){
		this.pan = panes.getPan();
		this.cant = this.cant + panes.getCant();
		this.precio = calcularPrecioTotal(this.pan, this.cant);
		return this;
	}*/

	
	
	
}
