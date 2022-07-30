package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Doctor;

public interface IDoctorService {

	public void insertarDoctor(Doctor cliente);
	
	public Doctor buscar(Integer id);
	public void actualizar(Doctor doctor);
	public void eliminar(Integer id);
	public Doctor buscarCedula(String cedula);
}
