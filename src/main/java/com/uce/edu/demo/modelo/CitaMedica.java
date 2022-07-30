package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "cita_medica")
public class CitaMedica {
	
	@Id
	@Column(name="cita_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cita_med_name_gerneration")
	@SequenceGenerator(name = "cita_med_name_gerneration",sequenceName = "cita_med_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="cime_numero")
	private String numero;
	
	@Column(name="cime_id")
	private LocalDateTime fechaCita;
	
	@Column(name="cime_valor_cita")
	private BigDecimal valorCita;
	
	@Column(name="cime_lugar_cita")
	private String lugarCita;
	
	@Column(name="cime_diagnostico")
	private String diagnostico; 
	
	@Column(name="cime_receta")
	private String receta;
	
	@Column(name="cime_fecha_control")
	private LocalDateTime fechaControl;
	
	
	@ManyToOne
	@JoinColumn(name = "cime_id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "cime_id_doctor")
    private Doctor doctor;

    
    //set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
    
    
    

}
