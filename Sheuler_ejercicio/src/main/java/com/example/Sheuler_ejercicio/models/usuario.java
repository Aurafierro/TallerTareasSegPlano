package com.example.Sheuler_ejercicio.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="id_usuario",nullable=false,length=36)
	private String id_usuario;

	@Column(name="tipo_documento",nullable=false,length=36)
	private String tipo_documento;
	
	@Column(name="numero_documento",nullable=false,length=36)
	private String numero_documento;
	
	@Column(name="nombre_completo",nullable=false,length=100)
	private String nombre_completo;
	
	@Column(name="fecha_nacimiento",nullable=false,length=36)
	private Date fecha_nacimiento;
	
	@Column(name="contrasena",nullable=false,length=36)
	private String contrasena;
	
	@Column(name="fecha_ultima_actualizacion_contrasena",nullable=false,length=36)
	private Date fecha_ultima_actualizacion_contrasena;
	
	@Column(name="fecha_ultimo_inicio_sesion",nullable=false,length=36)
	private Date fecha_ultimo_inicio_sesion;
	
	@Column(name="estado",nullable=false,length=36)
	private String estado;
	
	@Column(name="correo_electronico",nullable=false,length=36)
	private String correo_electronico;
	
	@Column(name="notificacion",nullable=false,length=36)
	private Boolean notificacion;

	

	public String getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getTipo_documento() {
		return tipo_documento;
	}



	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}



	public String getNumero_documento() {
		return numero_documento;
	}



	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}



	public String getNombre_completo() {
		return nombre_completo;
	}



	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}



	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public Date getFecha_ultima_actualizacion_contrasena() {
		return fecha_ultima_actualizacion_contrasena;
	}



	public void setFecha_ultima_actualizacion_contrasena(Date fecha_ultima_actualizacion_contrasena) {
		this.fecha_ultima_actualizacion_contrasena = fecha_ultima_actualizacion_contrasena;
	}



	public Date getFecha_ultimo_inicio_sesion() {
		return fecha_ultimo_inicio_sesion;
	}



	public void setFecha_ultimo_inicio_sesion(Date fecha_ultimo_inicio_sesion) {
		this.fecha_ultimo_inicio_sesion = fecha_ultimo_inicio_sesion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCorreo_electronico() {
		return correo_electronico;
	}



	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}



	public Boolean getNotificacion() {
		return notificacion;
	}



	public void setNotificacion(Boolean notificacion) {
		this.notificacion = notificacion;
	}



	public usuario(String id_usuario, String tipo_documento, String numero_documento, String nombre_completo,
			Date fecha_nacimiento, String contrasena, Date fecha_ultima_actualizacion_contrasena,
			Date fecha_ultimo_inicio_sesion, String estado, String correo_electronico, Boolean notificacion) {
		super();
		this.id_usuario = id_usuario;
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
		this.nombre_completo = nombre_completo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.contrasena = contrasena;
		this.fecha_ultima_actualizacion_contrasena = fecha_ultima_actualizacion_contrasena;
		this.fecha_ultimo_inicio_sesion = fecha_ultimo_inicio_sesion;
		this.estado = estado;
		this.correo_electronico = correo_electronico;
		this.notificacion = notificacion;
	}



	public usuario() {
		super();
	}



	public boolean contieneCamposVacios() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
