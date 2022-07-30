package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;

public interface IPacienteRepository {
	public void insertarPaciente(Paciente cliente);
	
	public Paciente buscar(Integer id);
	public void actualizar(Paciente paciente);
	public void eliminar(Integer id);
	public Paciente buscarCedula(String cedula);
}
