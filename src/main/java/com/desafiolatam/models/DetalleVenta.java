package com.desafiolatam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;
	private Integer cantidad;
	//private Venta venta;
	
	//ManyToMany (2 OneToMany)
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "detalle_ventas_productos", 
			joinColumns = @JoinColumn(name = "detalle_venta_id"), 
			inverseJoinColumns = @JoinColumn(name = "producto_id")
			)
	private List<Producto> listaProductos;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public DetalleVenta() {
		super();
	}
    
	public DetalleVenta(Long id, Date fecha, Integer cantidad, List<Producto> listaProductos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.listaProductos = listaProductos;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
