package com.mycompany.controller;


import com.mycompany.utils.CitaAgendadaVO;
import com.mycompany.utils.JpaUtils;

import java.util.List;

import com.mycompany.dao.CitaDao;
import com.mycompany.modelo.cita.Cita;

public class CitaController {
 // ATRIBUTOS	
		private CitaDao citaDao;
		
 // CONSTRUCTORES
		public CitaController() {
			citaDao = new CitaDao(new JpaUtils().getEntityMan(), Cita.class);
		}
		
 // MÉTODOS
	public CitaAgendadaVO buscarCitaMascotaYDuenioActivo(Integer idMascota) {
		return citaDao.buscarCitaMascotaYDuenioActivo(idMascota);
	/*	if(citaAgendadaVO != null) {
			citaAgendadaVO.setCitaFYH(null);
			citaAgendadaVO.setyMascota(null);
		} */
	//	return citaAgendadaVO;
	}
	
	public Cita buscarCitaActiva(Integer idDuenio, String nombreDuenio, Integer idMascota, String nombreMascota,
			Integer idCita) {
		return citaDao.buscarCitaActiva(idDuenio, nombreDuenio, idMascota, nombreMascota, idCita);
	}
	
	public void actualizarCita(Cita cita) {
		citaDao.actualizar(cita);
	}
	
	public void agendarCita(Cita cita) {
		citaDao.guardar(cita);
	}

		
}
