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
@Table(name = "consultorios")
public class consultoriosModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	@Getter @Setter private Long id_consultorio;
	
	public Long getId_consultorio() {
		return id_consultorio;
	}

	public void setId_consultorio(Long id_consultorio) {
		this.id_consultorio = id_consultorio;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	@Getter @Setter private Integer piso;
	
}
