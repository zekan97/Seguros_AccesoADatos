package com.hibernate.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="seguro", 
       uniqueConstraints={@UniqueConstraint(columnNames={"idSeguro"})})
public class Seguro {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idSeguro", nullable=false, unique=true, length=11)
	private int idSeguro;
	@Column(name="nif", nullable=false, unique=true, length=9)
	private String nif;
	@Column(name="nombre", nullable=false, length=100)
	private String nombre;
	@Column(name="ape1", nullable=false, length=100)
	private String ape1;
	@Column(name="ape2", nullable=false, length=100)
	private String ape2;
	@Column(name="edad", nullable=false, length=3)
	private int edad;
	@Column(name="mayorEdad", nullable=false, length=1)
	private boolean mayorEdad;


	@Column(name="sexo", nullable=false, length=1)
	private int sexo;
	@Column(name="casado", nullable=false, length=1)
	private String casado;

	@Column(name="numHijos", nullable=false, length=2)
	private int numHijos;
	@Column(name="fechaCreacion", nullable=false)
	private Date fechaCreacion;
	@Column(name="tipoSeguro", nullable=false, length=20)
	private String tipoSeguro;
	@Column(name="fechaNacimiento", nullable=false)
	private Date fechaNacimiento;
	@Column(name="horaContacto", nullable=false)
	private Date horaContacto;
	
	
	public Date getHoraContacto() {
		return horaContacto;
	}
	public void setHoraContacto(Date horaContacto) {
		this.horaContacto = horaContacto;
	}
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe1() {
		return ape1;
	}
	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}
	public String getApe2() {
		return ape2;
	}
	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public String getCasado() {
		return casado;
	}
	public void setCasado(String casado) {
		this.casado = casado;
	}
	
	public boolean isMayorEdad() {
		return mayorEdad;
	}
	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String toString() {
		return "Seguros [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre=" 
				+ nombre + "apellido1" + ape1 + "apellido2" + ape2 + "edad" + 
				edad + "sexo" + sexo + ", casado=" + casado +", numero de hijos"
				+ "="+ numHijos + ", fecha="+ fechaCreacion +", tipo="+ tipoSeguro + 
				"] \n";
	}
}
