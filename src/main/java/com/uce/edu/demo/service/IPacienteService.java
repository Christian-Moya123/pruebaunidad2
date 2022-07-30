package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;

public interface IPacienteService{


	public void insertarPaciente(Paciente paciente);
	
	public Paciente buscar(Integer id);
	public void actualizar(Paciente paciente);
	public void eliminar(Integer id);
	public Paciente buscarCedula(String cedula);
	
	public List<PacienteSencillo> consultarPacienteSencillo(LocalDateTime fecha, String genero);
}
