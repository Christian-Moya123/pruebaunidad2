package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.modelo.PacienteSencillo;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2EcApplication implements CommandLineRunner {
	
	private static Logger logger = Logger.getLogger(PruebaUnidad2EcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2EcApplication.class, args);
	}

	@Autowired
	private ICitaMedicaService citaMedicaService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Funcionalidad 1 Insertar Doctores
		Doctor doc1=  new Doctor();
		doc1.setCedula("0001");
		doc1.setNombre("Abel");
		doc1.setApellido("Solano");
		doc1.setFechaNacimiento(LocalDateTime.of(1959, 12,22,0,0));
		doc1.setNumeroConsultorio("ccc2");
		doc1.setCodigoSenescyt("aa1");
		doc1.setGenero("M");
		
		Doctor doc2=  new Doctor();
		doc2.setCedula("0002");
		doc2.setNombre("Anastacia");
		doc2.setApellido("Merinda");
		doc2.setFechaNacimiento(LocalDateTime.of(1959, 12,22,0,0));
		doc2.setNumeroConsultorio("ccc3");
		doc2.setCodigoSenescyt("aa4");
		doc2.setGenero("F");
		
		this.doctorService.insertarDoctor(doc1);
		this.doctorService.insertarDoctor(doc2);
		
		//Funcionalidad 2 Insertar Pacientes
		Paciente pa1 = new Paciente();
		pa1.setCedula("001");
		pa1.setNombre("Alex");
		pa1.setApellido("Charro");
		pa1.setFechaNacimiento(LocalDateTime.of(1998, 2, 12, 0, 0));
		pa1.setCodigoSeguro("000a");
		pa1.setEstatura("33 cm");
		pa1.setPeso("323");
		pa1.setGenero("M");
		
		Paciente pa2 = new Paciente();
		pa2.setCedula("003");
		pa2.setNombre("Maria");
		pa2.setApellido("Tumbaico");
		pa2.setFechaNacimiento(LocalDateTime.of(1899, 5, 6, 0, 0));
		pa2.setCodigoSeguro("000b");
		pa2.setEstatura("16 cm");
		pa2.setPeso("222");
		pa2.setGenero("F");
		
		this.pacienteService.insertarPaciente(pa1);
		this.pacienteService.insertarPaciente(pa2);
		
		
		//Funcionalidad 3 Agendar Cita Medica
		
		CitaMedica citaMe = this.citaMedicaService.agendarCita("01", LocalDateTime.of(2018, 5,5,0,0), new BigDecimal(100), "Quitumbe", "0002", "001");
		logger.info("Cita Medica: " + citaMe);
		
		CitaMedica citaMe2 = this.citaMedicaService.agendarCita("02", LocalDateTime.of(2022, 1,12,0,0), new BigDecimal(50), "Solanda", "0001", "003");
		logger.info("Cita Medica: " + citaMe);
		
		
		//Funcionalidad 4 aactualizar
		
		this.citaMedicaService.actualizarCitaM("01", "cancer", "paracetamol", LocalDateTime.now());
		
		
		//Funcionalidad 5  reporte de pacientes
		List<PacienteSencillo> listaPacientes = this.pacienteService.consultarPacienteSencillo(LocalDateTime.of(1898, 5,5,0,0), "M");
		
		for(PacienteSencillo pItem:listaPacientes) {
			logger.debug("rEPORTE DE PERSONAS  " + pItem);

		}
	}

	
	
	
	
	
	
	
}
