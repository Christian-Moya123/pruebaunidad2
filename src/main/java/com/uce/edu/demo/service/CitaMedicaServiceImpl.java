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
	public CitaMedica crearCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p = pacienteService.buscarCedula(cedulaPaciente);
		Doctor d = doctorService.buscarCedula(cedulaDoctor);
		
		CitaMedica citaMed = new CitaMedica();
		citaMed.setNumero(numero);
		citaMed.setFechaCita(fechaCita);
		citaMed.setValorCita(valorCita);
		citaMed.setLugarCita(lugarCita);
		citaMed.setDoctor(d);
		citaMed.setPaciente(p);
		
		return citaMedicaRepository.insertarCitaMedica(citaMed);
	}

	@Override
	public CitaMedica actualizarCitaM(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		CitaMedica citaMedica = citaMedicaRepository.buscarNumero(numero);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaControl(fechaControl);
		citaMedicaRepository.actualizar(citaMedica);
		
		return citaMedica;
	}

	@Override
	public List<CitaMedica> reporteCitaM(LocalDateTime fecha, BigDecimal valor) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.reporteCitaM(fecha, valor);
	}

}
