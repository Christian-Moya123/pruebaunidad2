package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Doctor;

import com.uce.edu.demo.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepository idoctorJpaRepository; 

	@Override
	public void insertarDoctor(Doctor cliente) {
		// TODO Auto-generated method stub
		this.idoctorJpaRepository.insertarDoctor(cliente);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.idoctorJpaRepository.buscar(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.idoctorJpaRepository.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.idoctorJpaRepository.eliminar(id);
	}

	@Override
	public Doctor buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.idoctorJpaRepository.buscarCedula(cedula);
	}

	
}
