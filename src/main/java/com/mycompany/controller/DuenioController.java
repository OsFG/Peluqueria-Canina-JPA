package com.mycompany.controller;

import com.mycompany.utils.JpaUtils;

import com.mycompany.dao.DuenioDao;
import com.mycompany.modelo.duenio.Duenio;

public class DuenioController {
 // ATRIBUTOS
	private DuenioDao duenioDao;
	
	public DuenioController() {
		this.duenioDao = new DuenioDao(new JpaUtils().getEntityMan(), Duenio.class);
	}
	public void guardar(Duenio duenio) {
		duenioDao.guardar(duenio);
	}

	public Duenio buscarDuenioPorNombreYTelefono(String nombreDuenio, String telefono) {
		return duenioDao.buscarPorNombreYTelefono(nombreDuenio, telefono);	
	}
	
	public void actualizarDuenioPorId(Integer idDuenio, String nombreDuenio, String telefono, String direccion) {
		Duenio duenio = new Duenio();
		duenio.setIdDuenio(idDuenio);
		if(!nombreDuenio.isEmpty()) {duenio.setNombreDuenio(nombreDuenio);}
		if(!telefono.isEmpty()) {duenio.setTelefono(telefono);}
		if(!direccion.isEmpty()) {duenio.setDireccion(direccion);}
		duenioDao.actualizar(duenio);
	}
	
	public void desactivarDuenioPorId(Integer idDuenio) {
		duenioDao.desactivarPorId(idDuenio);
	}

	public Duenio buscarID(Integer idDuenio) {
		return duenioDao.buscarID(idDuenio);
	}
}
