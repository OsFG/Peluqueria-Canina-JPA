package com.mycompany.modelo.mascota;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.duenio.Duenio;

@Entity
@Table(name = "tbmascotas")
public class Mascota {
	
 // ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMascota;
	
	@Column(length = 15)
	private String nombreMascota;
	
	@Enumerated(EnumType.STRING)
	private Raza raza;
	
	@Column(length = 18)
	private String color;
	
	@Column(length = 60)
	private String alergico;
	
	@Column(length = 150)
	private String atencionEspecial;
	
	@Column(length = 150)
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "idDuenio") 
	private Duenio duenio;
	
	@OneToMany(mappedBy = "mascota",
			   fetch = FetchType.LAZY)
	private List<Cita> registroCitas;

 //	CONSTRUCTORES
	public Mascota() {		
	 }
	
	public Mascota(Integer idMascota, String nombreMascota, Raza raza) {
		this.idMascota = idMascota;
		this.nombreMascota = nombreMascota;
	 	this.raza = raza;
	}
	
	public Mascota(Integer idMascota, String nombreMascota, Raza raza, Duenio duenio) {
		this(idMascota, nombreMascota, raza);
	 	this.duenio = duenio;
	 }
	
	public Mascota(String nombreMascota, String color, Raza raza, String alergico, String atencionEspecial, String observaciones, Duenio duenio) {
		this.nombreMascota = nombreMascota;
		this.color = color;
		this.raza = raza;
		this.alergico = alergico; 
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
		this.duenio = duenio;
	}
	
	public Mascota(Integer idMascota, String nombreMascota, String color, Raza raza, String alergico, String atencionEspecial, String observaciones, Duenio duenio) {
		this(nombreMascota, color, raza, alergico, atencionEspecial, observaciones, duenio);
		this.idMascota = idMascota;
		
	}
	
 public Mascota(Integer idMascota, Raza raza, String alergico, String atencionEspecial, String observaciones) {
	 	this.idMascota = idMascota;
	 	this.raza = raza;
		this.alergico = alergico; 
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
	}

//MÉTODOS 
	public Integer getIdMascota() {
		return idMascota;
	}
	
	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}
	
	public String getNombreMascota() {
		return nombreMascota;
	}
	
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	
	public Raza getRaza() {
		return raza;
	}
	
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getAlergico() {
		return alergico;
	}
	
	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}
	
	public String getAtencionEspecial() {
		return atencionEspecial;
	}
	
	public void setAtencionEspecial(String atencionEspecial) {
		this.atencionEspecial = atencionEspecial;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public Duenio getDuenio() {
		return duenio;
	}
	
	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}
	
	public List<Cita> getRegistroCitas() {
		return registroCitas;
	}
	
	public void setRegistroCitas(List<Cita> registroCitas) {
		this.registroCitas = registroCitas;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", nombreMascota=" + nombreMascota + ", raza=" + raza + ", color="
				+ color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alergico, atencionEspecial, color, duenio, idMascota, nombreMascota, observaciones, raza,
				registroCitas);
	}

}
