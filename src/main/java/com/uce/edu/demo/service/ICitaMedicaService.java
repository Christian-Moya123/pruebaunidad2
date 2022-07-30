package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedica;

public interface ICitaMedicaService {

	public CitaMedica agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String cedulaDoctor , String cedulaPaciente );
	public CitaMedica actualizarCitaM(String numeroCita, String diagnostico, String receta, LocalDateTime fechaCita);

	public void actualizarNCita(String nCitaMedica , String diagnostico, String receta, LocalDateTime fecha);


}
