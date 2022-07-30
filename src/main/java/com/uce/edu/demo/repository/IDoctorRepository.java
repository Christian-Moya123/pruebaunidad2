package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;

public interface IDoctorRepository {
	public void insertarDoctor(Doctor cliente);
	
	public Doctor buscar(Integer id);
	public void actualizar(Doctor doctor);
	public void eliminar(Integer id);
	public Doctor buscarCedula(String cedula);

}
