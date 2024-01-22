package com.mycompany.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.mycompany.modelo.mascota.Mascota;

public class MascotaDao extends GenericDao<Mascota>{
	
//	ATRIBUTOS (Heredados)
 // CONSTRUCTORES		
	public MascotaDao(EntityManager em, Class<Mascota> clase) {
		super(em, clase);		
	}
	
// MÉTODOS
	public void guardar(Mascota mascota) {
		super.guardar(mascota);
	}
	
	public void actualizar(Mascota mascota) {
		super.actualizar(mascota);
	}
	
	public void eliminarRegistro(Mascota mascota) {
		super.eliminarRegistro(mascota);
	}
	
	public Mascota buscarID(Integer id) {
		return super.buscarID(id);
	}
	
	public List<Mascota> findAll(){
		String queryJPQL = "SELECT M FROM tbmascotas AS M";
		return super.findAll(queryJPQL);
	}

	public Mascota buscarMascotaPorIds(Integer idDuenio, Integer idMascota) {
		Mascota mascota = null;
		String jpql = "SELECT m FROM Mascota m WHERE m.idMascota=:idMascota AND m.duenio.idDuenio=:idDuenio";
		try {
			mascota = em.createQuery(jpql, clase)
						.setParameter("idMascota", idMascota)
						.setParameter("idDuenio", idDuenio)
						.getSingleResult();
		}catch(Exception e) {
			e.getCause();
			e.getMessage();
		}finally {
			super.desconectar();
		}
		return mascota;
	}

	public Mascota buscarMascotaPorNombreMascotaYIdDuenio(String nombre, Integer idDuenio) {
		Mascota mascota = null;
		String jpql = "SELECT m FROM Mascota m WHERE m.nombreMascota=:nombre AND m.duenio.idDuenio=:idDuenio";
		try {
			super.conectar();
			mascota = em.createQuery(jpql, clase)
						.setParameter("nombre", nombre)
						.setParameter("idDuenio", idDuenio)
						.getSingleResult();
		}catch(Exception e) {
			e.getCause();
			e.getMessage();
		}finally {
			super.desconectar();
		}
		return mascota;
	}
	
	
}
