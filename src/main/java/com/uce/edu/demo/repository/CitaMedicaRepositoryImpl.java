package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.PruebaUnidad2EcApplication;
import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Paciente;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{
	
	private static Logger logger = Logger.getLogger(PruebaUnidad2EcApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CitaMedica insertarCitaMedica(CitaMedica cMedica) {
		// TODO Auto-generated method stub
		logger.info("Se ha insertado la cita");
		this.entityManager.persist(cMedica);
		
		
		return cMedica;
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		
		logger.info("Se ha actualizado la cita");
		
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarNumero(String numero) {
		// TODO Auto-generated method stub
		logger.info("Se ha buscado la cita");
		
		Query query = this.entityManager.createQuery("SELECT c FROM  CitaMedica c WHERE c.numero = :datoNumero ");
		query.setParameter("datoNumero", numero);
		
		return  (CitaMedica) query.getSingleResult();
	}

	@Override
	public void actualizarNCita(String nCitaMedica , String diagnostico, String receta, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("UPDATE CitaMedica p SET p.diagnostico = :datoDiagnostico, p.receta = : dReceta, p.fechaProximaCita = : dFecha WHERE p.numeroCita = :dnumeroCita");
		query.setParameter("dnumeroCita", nCitaMedica);
		query.setParameter("dReceta", receta);
		query.setParameter("dFecha", fecha);
		query.setParameter("datoDiagnostico", diagnostico);
		
		query.getSingleResult();
	}

	


}
