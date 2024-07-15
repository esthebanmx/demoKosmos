package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "citas")
public class citasModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	@Getter @Setter private Long id_citas;
	
	public Long getId_citas() {
		return id_citas;
	}
	public void setId_citas(Long id_citas) {
		this.id_citas = id_citas;
	}
	public Integer getId_consultorio() {
		return id_consultorio;
	}
	public void setId_consultorio(Integer id_consultorio) {
		this.id_consultorio = id_consultorio;
	}
	public Integer getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(Integer id_doctor) {
		this.id_doctor = id_doctor;
	}
	public String getHorario_consulta() {
		return horario_consulta;
	}
	public void setHorario_consulta(String horario_consulta) {
		this.horario_consulta = horario_consulta;
	}
	public String getNombre_paciente() {
		return nombre_paciente;
	}
	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}
	@Getter @Setter private Integer id_consultorio;
	@Getter @Setter private Integer id_doctor;
	@Getter @Setter private String horario_consulta;
	@Getter @Setter private String nombre_paciente;


}
