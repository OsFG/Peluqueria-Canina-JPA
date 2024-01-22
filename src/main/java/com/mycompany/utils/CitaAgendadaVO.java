package com.mycompany.utils;

import java.time.LocalDateTime;

import com.mycompany.modelo.mascota.Mascota;

public class CitaAgendadaVO {
	
	public LocalDateTime citaFYH;
	public Boolean citaActiva;
	public Integer idCita;
	public Integer idMascota;
	public Boolean duenioActivo;
	
 // CONSTRUCTORES		
	public CitaAgendadaVO(LocalDateTime citaFYH, Boolean citaActiva, Integer idCita, Integer idMascota, Boolean duenioActivo) {
		this.citaFYH = citaFYH;
		this.citaActiva = citaActiva;
		this.idCita = idCita;
		this.idMascota = idMascota;
		this.duenioActivo = duenioActivo;
	}
 // MÉTODOS
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

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Integer getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public Boolean getDuenioActivo() {
		return duenioActivo;
	}
		
}
