package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=4,max=20)
	private String nombre;
	@Size(min=4,max=20)
	private String apellido;
	@Size(min=6)
	private String correo;
	
	//Relacion 1 a 1 (OneToOne)
	//direccion
	@OneToOne(mappedBy="cliente", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Direccion direccion;

	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	public Cliente() {
		super();
	}

	public Cliente(Long id, @Size(min = 4, max = 20) String nombre, @Size(min = 4, max = 20) String apellido,
			@Size(min = 6) String correo, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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
