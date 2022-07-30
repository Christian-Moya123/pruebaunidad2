package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.PruebaUnidad2EcApplication;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;



@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository{

	private static Logger logger = Logger.getLogger(PruebaUnidad2EcApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDoctor(Doctor cliente) {
		// TODO Auto-generated method stub
		logger.debug("Se ha insertado el doctor");
		this.entityManager.persist(cliente);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		logger.info("Se ha buscado el doctor");
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		logger.info("Se ha actulizado el doctor");
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		logger.info("Se ha eliminado el doctor");
		Doctor doc = this.buscar(id);
		this.entityManager.remove(doc);
	}
	
	public Doctor buscarCedula(String cedula) {
		Query query = this.entityManager.createQuery("SELECT d FROM  Doctor d WHERE d.cedula = :datoCedula ");
		query.setParameter("datoCedula", cedula);
		
		return  (Doctor) query.getSingleResult();
	}

}
