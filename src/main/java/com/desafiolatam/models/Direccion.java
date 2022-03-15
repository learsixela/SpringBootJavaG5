package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="direciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer numero;
	private String sector;
	private String ciudad;
	private String region;
	
	//1 a 1 (llevara la FK)
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	public Direccion() {
		super();
	}

	public Direccion(Long id, String nombre, Integer numero, String sector, String ciudad, String region,
			Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
		this.sector = sector;
		this.ciudad = ciudad;
		this.region = region;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getSector() {
		return sector;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getRegion() {
		return region;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setCliente(Cliente cliente) {
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
}
