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
import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class AaT1Application implements CommandLineRunner{

	private static Logger logger = Logger.getLogger(AaT1Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AaT1Application.class, args);
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
	
		for (int i=1; i <=10; i++){
			Paciente pa1 = new Paciente();
			pa1.setApellido("b"+i);
			pa1.setCedula("001"+i);
			pa1.setCodigoIess("00a"+i);
			pa1.setEdad("12"+i);
			pa1.setEstatura("33"+i);
			pa1.setFechaNacimiento(LocalDateTime.of(1998+i, 2+i, 12, 0, 0));
			pa1.setNombre("a"+i);
			pa1.setPeso("323"+i);
			
			this.pacienteService.insertarPaciente(pa1);
		}
		
		

		for (int i=1; i <=10; i++){
		Doctor doc1=  new Doctor();
		doc1.setApellido("v"+i);
		doc1.setCedula("0001"+i);
		doc1.setCodigoSenescyt("aaaa1"+i);
		doc1.setFechaNacimiento(LocalDateTime.now());
		doc1.setNombre("aa"+i);
		doc1.setNumeroConsultorio("ccc2"+i);
		doc1.setSueldo(new BigDecimal(2009+i));
		
		
		this.doctorService.insertarDoctor(doc1);
		
		}
		

		for (int i=1; i <=10; i++){
			
		
		CitaMedica citaMe = this.citaMedicaService.crearCita("009"+i, LocalDateTime.of(2015+i, 4,12, 0, 0), new BigDecimal(400+i*10), "calle"+i, "0001"+i, "001"+i);
		System.out.println(citaMe.getId());
		
		}
		
		for (int i=1; i <=10; i++){
		
		
		
		}
		
		
		List<CitaMedica> citasMedicas =  citaMedicaService.reporteCitaM( LocalDateTime.of(2019, 4,12, 0, 0), new BigDecimal(450));
		
		if(citasMedicas != null && citasMedicas.size()>0) {
			for(CitaMedica item : citasMedicas) {
				System.out.println(item.getNumero() +" " + item.getFechaCita()+" " +item.getValorCita()+" " + item.getFechaControl());
			}
		}
		
		logger.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
		
	}

}
