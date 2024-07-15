package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.citasModel;
import com.example.demo.repositories.citasRepository;


@Service
public class citasService {
	
	@Autowired
	citasRepository citRepository;
	
	public ArrayList<citasModel> obteneCitas(){
		return (ArrayList<citasModel>)citRepository.findAll();
	}
	
	public citasModel guardarcita(citasModel cita) {
		return citRepository.save(cita);
	}
	
	public Optional<citasModel> obtenerPorId(Long id){
		return citRepository.findById(id);
	}
		

	public boolean eliminarCita(Long id) {
		try {
			citRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
