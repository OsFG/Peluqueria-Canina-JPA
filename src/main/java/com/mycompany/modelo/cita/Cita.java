package com.mycompany.modelo.cita;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mycompany.modelo.mascota.Mascota;

@Entity
@Table(name="tbcitas")
public class Cita {

// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCita;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "idMascota") 
	private Mascota mascota;

	private LocalDateTime citaFYH;
	private Boolean citaActiva;
	
// CONSTRUCTORES
	public Cita() {
	}
	
	public Cita(Mascota mascota, LocalDateTime citaFYH) {
		this.mascota = mascota;
		this.citaFYH = citaFYH;
		this.citaActiva = true;
	}
	
	public Cita(Integer idCita, Mascota mascota, LocalDateTime citaFYH) {
		this(mascota, citaFYH);
		this.idCita = idCita;
		this.citaActiva = true;
	}

// MÉTODOS
	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getCitaFYH() {
		return citaFYH;
	}

	public void setCitaFYH(LocalDateTime citaFYH) {
		this.citaFYH = citaFYH;
	}

	public Boolean getCitaActiva() {
		return citaActiva;
	}

	public void setCitaActiva(Boolean citaActiva) {
		this.citaActiva = citaActiva;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	
	
	
}
