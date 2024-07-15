package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.consultoriosModel;
import com.example.demo.repositories.consultorioRepository;

@Service
public class consultorioService {
	
	@Autowired
	consultorioRepository consulRepository;
	
	public ArrayList<consultoriosModel> obtenerConsultorios(){
		return (ArrayList<consultoriosModel>)consulRepository.findAll();
	}
	
	public consultoriosModel guardarConsultorio(consultoriosModel doctor) {
		return consulRepository.save(doctor);
	}
	
	public Optional<consultoriosModel> obtenerPorId(Long id){
		return consulRepository.findById(id);
	}	

	public boolean eliminarConsultorio(Long id) {
		try {
			consulRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
