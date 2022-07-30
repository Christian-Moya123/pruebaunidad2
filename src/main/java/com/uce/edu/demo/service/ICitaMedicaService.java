package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedica;

public interface ICitaMedicaService {

	public CitaMedica crearCita(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String cedulaDoctor , String cedulaPaciente );
	public CitaMedica actualizarCitaM(String numero, String diagnostico, String receta, LocalDateTime fechaControl);

	public List<CitaMedica> reporteCitaM(LocalDateTime fecha, BigDecimal valor);


}
