package com.mycompany.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.duenio.Duenio;
import com.mycompany.modelo.mascota.Mascota;
import com.mycompany.utils.CitaAgendadaVO;


public class CitaDao extends GenericDao<Cita>{
	
//	ATRIBUTOS (Heredados)
 // CONSTRUCTORES		
	public CitaDao(EntityManager em, Class<Cita> clase) {
		super(em, clase);		
	}
	
// MÉTODOS
	public void guardar(Cita cita) {
		super.guardar(cita);
	}
	
	public void actualizar(Cita cita) {
		super.actualizar(cita);
	}
	
	public void eliminarRegistro(Cita cita) {
		super.eliminarRegistro(cita);
	}
	
	public Cita buscarID(Integer id) {
		return super.buscarID(id);
	}
	
	public List<Cita> findAll(){
		String queryJPQL = "SELECT c FROM Cita c";
		return super.findAll(queryJPQL);
	}

	public CitaAgendadaVO buscarCitaMascotaYDuenioActivo(Integer idMas) {
		CitaAgendadaVO citaAngendada = null;
		String jpql = "SELECT new com.mycompany.utils.CitaAgendadaVO("
					   + "cita.citaFYH, "
					   + "cita.citaActiva, "
					   + "cita.idCita, "
					   + "cita.mascota.idMascota, "
					   + "duenio.activo) "
					   + "FROM Cita cita "
					   + "JOIN cita.mascota mascota "
					   + "JOIN mascota.duenio duenio "
					   + "WHERE mascota.idMascota=:idMas";
		try {
			super.conectar();
			citaAngendada  = em.createQuery(jpql, CitaAgendadaVO.class).setParameter("idMas", idMas).getResultStream().findFirst().orElse(null);
		}catch(Exception e) {
			System.out.println("No se encontró Cita: " + e.getCause() + " " + e.getMessage());
		}finally {
			super.desconectar();
		}
		return citaAngendada;
		
	}

	public Cita buscarCitaActiva(Integer idDuenio, String nombreDuenio, Integer idMascota, String nombreMascota,
			Integer idCita) {
		Cita cita = null;
		try {
			super.conectar();
			CriteriaBuilder cBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Cita> cQuery = cBuilder.createQuery(clase);
			
			Root<Cita> raizCita = cQuery.from(clase);
			Root<Mascota> rMascota = cQuery.from(Mascota.class);
			Join<Cita, Mascota> joinMascota = raizCita.join("mascota");
			Join<Mascota, Duenio> joinDuenio = rMascota.join("duenio");
			
			Predicate filtros = cBuilder.and(cBuilder.equal(raizCita.get("citaActiva"), 1));
			if(idCita != null){
				filtros = cBuilder.and(filtros, cBuilder.equal(raizCita.get("idCita"), idCita));
			}
			if(idMascota != null) {
				filtros = cBuilder.and(filtros, cBuilder.equal(raizCita.get("mascota").get("idMascota"), idMascota));
			}
			if(nombreMascota !=null && !nombreMascota.trim().isEmpty()){
				filtros = cBuilder.and(filtros, cBuilder.equal(joinMascota.get("nombreMascota"), nombreMascota));
			}
			if(idDuenio != null) {
				filtros = cBuilder.and(filtros, cBuilder.equal(joinDuenio.get("idDuenio"), idDuenio));
			}
			if(nombreDuenio != null && !nombreDuenio.trim().isEmpty()) {
				filtros = cBuilder.and(filtros, cBuilder.equal(joinDuenio.get("nombreDuenio"), nombreDuenio));
			}
			
			cQuery= cQuery.select(raizCita)
						  .where(filtros);
			
			cita = em.createQuery(cQuery).getResultStream().findFirst().orElse(null);
		}catch(Exception e) {
			e.getCause()
			 .getMessage();
		}finally {
			super.desconectar();
		}
		return cita;
	}
	
	public static <T> T getSingleResult(TypedQuery<T> query) {
	    return query.setMaxResults(1).getResultList().stream().findFirst().orElse(null);
	}
}