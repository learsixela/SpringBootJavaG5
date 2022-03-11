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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autos")
public class Auto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	private Float motor;
	private String color;
	@Range(min=0, max=500)
	private float velocidad;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Auto() {
		super();
	}
	
	public Auto(Long id, String marca, Float motor, String color, float velocidad) {
		super();
		this.id = id;
		this.marca = marca;
		this.motor = motor;
		this.color = color;
		this.velocidad = velocidad;
	}

	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public Float getMotor() {
		return motor;
	}
	public String getColor() {
		return color;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setMotor(Float motor) {
		this.motor = motor;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
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
