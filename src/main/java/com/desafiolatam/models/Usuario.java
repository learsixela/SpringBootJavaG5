package com.desafiolatam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=4,max=20)
	private String nombre;
	@Size(min=4,max=20)
	private String apellido;
	
	@Email(message="Email no puede estar vacio")
	private String correo;
	
	@Size(min=6,message="Minimo deben ser 6 caracteres") //qwertyqwerty
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	private int genero;
	
    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Usuario() {
		super();
	}
	
	public Usuario( String nombre, String apellido, String correo, String password, int genero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.genero = genero;
	}
	
	public Usuario(Long id, String nombre, String apellido, String correo, String password, int genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.genero = genero;
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
	public String getPassword() {
		return password;
	}
	public int getGenero() {
		return genero;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
