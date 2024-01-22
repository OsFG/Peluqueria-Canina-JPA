package com.mycompany.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mycompany.modelo.duenio.Duenio;

public class DuenioDao extends GenericDao<Duenio> {
	
//	ATRIBUTOS (Heredados)
 // CONSTRUCTORES		
	public DuenioDao(EntityManager em, Class<Duenio> clase) {
		super(em, clase);		
	}
	
// MÉTODOS
	public void guardar(Duenio duenio) {
		super.guardar(duenio);
	}
	
	public void actualizar(Duenio duenio) {
		super.actualizar(duenio);
	}
	
	public void eliminarRegistro(Duenio duenio) {
		super.eliminarRegistro(duenio);
	}
	
	public Duenio buscarID(Integer id) {
		return super.buscarID(id);
	}
	
	public List<Duenio> findAll(){
		String queryJPQL = "SELECT d FROM Duenios d";
		return super.findAll(queryJPQL);
	}

	public void desactivarPorId(Integer idDuenio) {
		String queryJPQL = "UPDATE Duenios d SET d.activo = 0 WHERE idDuenio=:idDuenio";
		try {
			super.conectar();
			em.getTransaction().begin();
			em.createQuery(queryJPQL, Duenio.class);
			em.getTransaction().commit();
		}catch(Exception e) {
			super.hacerRollbackYDesconectar(e);
		}
		
	}

	public Duenio buscarPorNombreYTelefono(String nombreDuenio, String telefono) {
		Duenio duenio = null;
		String jpql = "SELECT d FROM Duenio d WHERE d.nombreDuenio=:nombreDuenio AND d.telefono=:telefono";
		try {
			super.conectar();
			duenio = em.createQuery(jpql, clase)
			  		   .setParameter("nombreDuenio", nombreDuenio)
					   .setParameter("telefono", telefono)
					   .getSingleResult();
			
		}catch(Exception e) {
			e.getCause();
			e.getMessage();
		}finally {
			super.desconectar();
		}
		return duenio;
	}


}
