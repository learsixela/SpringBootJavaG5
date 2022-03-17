package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "productos_ventas")
public class ProductoVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	private double precioProducto;//Historico
	private double precioVenta;//cantidad * precioProducto
	
	//producto
	//Relacion ManyToOne (llevara la FK)
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producto_id")
	private Producto producto;
	
	//venta
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="venta_id")
	private Venta venta;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public ProductoVenta() {
		super();
	}

	public ProductoVenta(Integer cantidad, double precioProducto, double precioVenta, Producto producto,
			Venta venta) {
		super();
		this.cantidad = cantidad;
		this.precioProducto = precioProducto;
		this.precioVenta = precioVenta;
		this.producto = producto;
		this.venta = venta;
	}
	
	public ProductoVenta(Long id, Integer cantidad, double precioProducto, double precioVenta, Producto producto,
			Venta venta) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precioProducto = precioProducto;
		this.precioVenta = precioVenta;
		this.producto = producto;
		this.venta = venta;
	}

	public Long getId() {
		return id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
