package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.PruebaUnidad2EcApplication;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;


@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository{
	private static Logger logger = Logger.getLogger(PruebaUnidad2EcApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente cliente) {
		
		logger.debug("Se ha insertado el paciente");
		this.entityManager.persist(cliente);
	}

	@Override
	public Paciente buscar(Integer id) {
		logger.info("Se buscado el paciente");
		return  this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		logger.info("Se ha actulizado el paciente");
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		logger.info("Se ha eliminado el paciente");
		Paciente paciente = this.buscar(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarCedula(String cedula) {
		Query query = this.entityManager.createQuery("SELECT p FROM  Paciente p WHERE p.cedula = :pCedula ");
		query.setParameter("pCedula", cedula);
		
		return (Paciente) query.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> consultarPacienteSencillo(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.modelo.PacienteSencillo (p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p Where p.fechaNacimiento > :datoFecha AND p.genero = :datoGenero ", PacienteSencillo.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoGenero", genero);
		
		return myQuery.getResultList();
	}

}
