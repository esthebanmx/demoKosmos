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

import com.example.demo.models.consultoriosModel;
import com.example.demo.services.consultorioService;

@RestController
@RequestMapping("/consultorios")
public class consultoriosController {
private Logger logger = Logger.getLogger(doctorController.class.getName());
	
	@Autowired
	consultorioService consService;
	
	@GetMapping
	public ArrayList<consultoriosModel> obtenerDoctores(){
		return consService.obtenerConsultorios();
	}
	
	@PostMapping  //test postman  http://localhost:8080/doctor method:POST  json= {"id_doctor": 6,"nombres": "Jesus Esteban","apellido_paterno": "Garcia","apellido_materno": "Garcia",    "especialidad": "Cirugia"}
	public consultoriosModel guardarDoctor(@RequestBody consultoriosModel consultorio) {		
		/*
		 * System.out.println(doctor.getNombres());
		 * System.out.println(doctor.getApellido_materno());
		 * System.out.println(doctor.getApellido_paterno());
		 * System.out.println(doctor.getEspecialidad());
		 */
		return this.consService.guardarConsultorio(consultorio);
	}
	
	@GetMapping(path = "/{id}")   //test con navegador localhost:8080/doctor/id
	public Optional<consultoriosModel> obtenerDoctorById(@PathVariable("id") Long id){
		return this.consService.obtenerPorId(id);
	}
	
	
	@DeleteMapping(path ="/{id}")  //test postman  http://localhost:8080/doctor/id  method:DELET
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.consService.eliminarConsultorio(id);
		if(ok) {
			return "Se elimino correctamente" + id;
		}else {
			return "No se pudo eliminar"+id;
		}
	}


}
