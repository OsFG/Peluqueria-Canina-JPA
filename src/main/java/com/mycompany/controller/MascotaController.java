package com.mycompany.controller;

import com.mycompany.dao.MascotaDao;
import com.mycompany.modelo.mascota.Mascota;
import com.mycompany.modelo.mascota.Raza;
import com.mycompany.utils.JpaUtils; 

public class MascotaController {
	
	private MascotaDao mascotaDao;
	
	public MascotaController(){
		this.mascotaDao = new MascotaDao(new JpaUtils().getEntityMan(), Mascota.class);
	}
	
	public void guardar(Mascota mascota) {
		mascotaDao.guardar(mascota);
	}

	public Mascota buscarMascotaPorNombreMascotaIdDuenio(String nombre, Integer idDuenio) {
		return mascotaDao.buscarMascotaPorNombreMascotaYIdDuenio(nombre, idDuenio);
	}
 
	public Mascota buscarMascotaPorIds(Integer idDuenio, Integer idMascota) {
		return mascotaDao.buscarMascotaPorIds(idDuenio, idMascota);
	}
	
	public void actualizarMascota(Integer idMascota, String nombreM, String alergico, String atencionEsp,
			String observaciones, Raza raza) {
		Mascota mascota = mascotaDao.buscarID(idMascota);
		if(!nombreM.isBlank()) {mascota.setNombreMascota(nombreM);}
		if(!alergico.isBlank()) {mascota.setAlergico(alergico);}
		if(!atencionEsp.isBlank()) {mascota.setAtencionEspecial(atencionEsp);}
		if(!observaciones.isBlank()) {mascota.setObservaciones(observaciones);}
		if(!raza.equals(Raza.SELECCIONAR_RAZAS)) {mascota.setRaza(raza);}
		mascotaDao.actualizar(mascota); 
	}
	
	public void eliminarMascota(String idMascota) {
		Integer idMas = Integer.parseInt(idMascota);
		Mascota mascota = mascotaDao.buscarID(idMas);
		mascotaDao.eliminarRegistro(mascota);
	}

	public Mascota buscarID(Integer idMascota) {
		return mascotaDao.buscarID(idMascota);
	}
}
