package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Paciente;


@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente cliente) {
		
		this.entityManager.persist(cliente);
	}

	@Override
	public Paciente buscar(Integer id) {
		
		return  this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		
		Paciente paciente = this.buscar(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarCedula(String cedula) {
		Query query = this.entityManager.createQuery("SELECT p FROM  Paciente p WHERE p.cedula = :pCedula ");
		query.setParameter("pCedula", cedula);
		
		return (Paciente) query.getSingleResult();
	}

}
