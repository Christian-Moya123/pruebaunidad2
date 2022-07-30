package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Paciente;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{
	

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CitaMedica insertarCitaMedica(CitaMedica cMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cMedica);
		return cMedica;
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarNumero(String numero) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT c FROM  CitaMedica c WHERE c.numero = :datoNumero ");
		query.setParameter("datoNumero", numero);
		
		return  (CitaMedica) query.getSingleResult();
	}

	@Override
	public List<CitaMedica> reporteCitaM(LocalDateTime fecha, BigDecimal valor) {
		Query query = this.entityManager.createQuery("SELECT c FROM  CitaMedica c WHERE c.fechaCita > :datofechaCita AND c.valorCita > :datoValorCita ");
		query.setParameter("datofechaCita", fecha);
		query.setParameter("datoValorCita", valor);
		
		return query.getResultList();
	}

}
