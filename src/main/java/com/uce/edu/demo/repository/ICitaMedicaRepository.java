package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	
	public CitaMedica insertarCitaMedica(CitaMedica cMedica);
	
	public void actualizar(CitaMedica citaMedica);
	
	public CitaMedica buscarNumero(String numero);
	
	
	public List<CitaMedica> reporteCitaM(LocalDateTime fecha, BigDecimal valor);
}
