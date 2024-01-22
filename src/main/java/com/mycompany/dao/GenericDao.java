package com.mycompany.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.utils.JpaUtils;

public class GenericDao<T> {
	
	protected EntityManager em;
	protected Class<T> clase;

	public GenericDao(EntityManager em, Class<T> clase) {
		this.em = em;
		this.clase = clase;
	}
	
	public void conectar() {
		if(!em.isOpen()) em = new JpaUtils().getEntityMan();
	}
	
	public void desconectar() {
		if(em.isOpen()) em.close();
	}
	
	public void guardar(T objEntidad) {
		try {
			conectar();
			em.getTransaction().begin();
			em.persist(objEntidad);
			em.getTransaction().commit();
	//		desconectar();
		}catch(Exception e) {
			hacerRollbackYDesconectar(e);
		}
	}
	
	public void actualizar(T objEntidad) {
		try {
			conectar();
			em.getTransaction().begin();
			em.merge(objEntidad);
			em.getTransaction().commit();
			desconectar();
		}catch(Exception e) {
		hacerRollbackYDesconectar(e);
		}
	}
	
	public void eliminarRegistro(T objEntidad) {
		try {
			conectar();
			em.getTransaction().begin();
			em.remove(objEntidad);
			em.getTransaction().commit();
			desconectar();
		}catch(Exception e){
		hacerRollbackYDesconectar(e);
		}
	}
	
	public List<T> findAll(String queryJPQL){
		try {
			conectar();
			return em.createQuery(queryJPQL, this.clase).getResultList();
		}catch(Exception e) {
			throw new RuntimeException("Error al hacer busqueda", e);
		}
		finally {
		desconectar();
		}
	}
	
	public T buscarID(Integer id) {
		try {
			conectar();
			return em.find(this.clase, id);
		}catch(Exception e) {
			throw new RuntimeException("Error al hacer busqueda", e);
		}
		finally {
		desconectar();
		}
	}
	
	public void hacerRollbackYDesconectar(Exception e) {
		try {
			if(em.isOpen()) {
			em.getTransaction().rollback();	
			}			
		}catch (Exception e1) {
			throw new RuntimeException("Error al hacer RollBack", e1);
		}finally {
			desconectar();
		}
		throw new RuntimeException("Ocurrió un error al modificar la Entidad", e);
	}

	public EntityManager getEm() {
		return em;
	}

}
