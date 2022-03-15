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
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	private Float monto;
	
	//Relacion ManyToOne (llevara la FK)
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    

    public Compra() {
		super();
	}
    
    
	public Compra(Long id, Date fecha, Float monto, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.cliente = cliente;
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
	public Float getMonto() {
		return monto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
