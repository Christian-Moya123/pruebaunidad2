package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;

public interface IPacienteService{


	public void insertarPaciente(Paciente paciente);
	
	public Paciente buscar(Integer id);
	public void actualizar(Paciente paciente);
	public void eliminar(Integer id);
	public Paciente buscarCedula(String cedula);
}
