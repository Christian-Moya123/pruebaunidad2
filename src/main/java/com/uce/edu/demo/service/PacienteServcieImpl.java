package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Paciente;

import com.uce.edu.demo.repository.IPacienteRepository;

@Service
public class PacienteServcieImpl implements IPacienteService{

	@Autowired
	private IPacienteRepository ipacienteJpaRepository; 
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.ipacienteJpaRepository.insertarPaciente(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ipacienteJpaRepository.buscar(id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.ipacienteJpaRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ipacienteJpaRepository.eliminar(id);
	}

	@Override
	public Paciente buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ipacienteJpaRepository.buscarCedula(cedula);
	}

}
