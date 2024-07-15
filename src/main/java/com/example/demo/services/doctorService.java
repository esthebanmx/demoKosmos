package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.doctoresModel;
import com.example.demo.repositories.doctorRepository;

@Service
public class doctorService {
	
	@Autowired
	doctorRepository doctorRepository;
	
	public ArrayList<doctoresModel> obtenerDoctores(){
		return (ArrayList<doctoresModel>)doctorRepository.findAll();
	}
	
	public doctoresModel guardarDoctor(doctoresModel doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Optional<doctoresModel> obtenerPorId(Long id){
		return doctorRepository.findById(id);
	}
	
	

	public boolean eliminarDoctor(Long id) {
		try {
			doctorRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
