package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.repository.ICitaMedicaRepository;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	
	@Override
	public CitaMedica agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p = pacienteService.buscarCedula(cedulaPaciente);
		Doctor d = doctorService.buscarCedula(cedulaDoctor);
		
		CitaMedica citaMed = new CitaMedica();
		citaMed.setNumeroCita(numeroCita);
		citaMed.setFechaCita(fechaCita);
		citaMed.setValorCita(valorCita);
		citaMed.setLugarCita(lugarCita);
		citaMed.setDoctor(d);
		citaMed.setPaciente(p);
		
		return citaMedicaRepository.insertarCitaMedica(citaMed);
	}

	@Override
	public CitaMedica actualizarCitaM(String numeroCita, String diagnostico, String receta, LocalDateTime fechaCita) {
		CitaMedica citaMedica = citaMedicaRepository.buscarNumero(numeroCita);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaCita(fechaCita);
		citaMedicaRepository.actualizar(citaMedica);
		
		return citaMedica;
	}

	@Override
	public void actualizarNCita(String nCitaMedica, String diagnostico, String receta, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarNCita(nCitaMedica, diagnostico, receta, fecha);
		
	}



}
