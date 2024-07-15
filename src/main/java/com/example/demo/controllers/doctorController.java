package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.doctoresModel;
import com.example.demo.services.doctorService;

@RestController
@RequestMapping("/doctor")
public class doctorController {
	
	private Logger logger = Logger.getLogger(doctorController.class.getName());
	
	@Autowired
	doctorService docService;
	
	@GetMapping
	public ArrayList<doctoresModel> obtenerDoctores(){
		return docService.obtenerDoctores();
	}
	
	@PostMapping  //test postman  http://localhost:8080/doctor method:POST  json= {"id_doctor": 6,"nombres": "Jesus Esteban","apellido_paterno": "Garcia","apellido_materno": "Garcia",    "especialidad": "Cirugia"}
	public doctoresModel guardarDoctor(@RequestBody doctoresModel doctor) {		
		/*
		 * System.out.println(doctor.getNombres());
		 * System.out.println(doctor.getApellido_materno());
		 * System.out.println(doctor.getApellido_paterno());
		 * System.out.println(doctor.getEspecialidad());
		 */
		return this.docService.guardarDoctor(doctor);
	}
	
	@GetMapping(path = "/{id}")   //test con navegador localhost:8080/doctor/id
	public Optional<doctoresModel> obtenerDoctorById(@PathVariable("id") Long id){
		return this.docService.obtenerPorId(id);
	}

	
	
	@DeleteMapping(path ="/{id}")  //test postman  http://localhost:8080/doctor/id  method:DELET
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.docService.eliminarDoctor(id);
		if(ok) {
			return "Se elimino correctamente" + id;
		}else {
			return "No se pudo eliminar"+id;
		}
	}

}
