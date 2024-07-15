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

import com.example.demo.models.citasModel;
import com.example.demo.services.citasService;

@RestController
@RequestMapping("/citas")
public class citasController {
	
	@Autowired
	citasService citService;
	
	@GetMapping
	public ArrayList<citasModel> obtenerCitas(){
		return citService.obteneCitas();
	}
	
	@PostMapping  //test postman  http://localhost:8080/citas method:POST  json= {"id_consultorio": "1", "id_doctor": "2", "horario_consulta": "10:00", "nombre_paciente": "Daniel Hernadez"}
	public citasModel guardarCita(@RequestBody citasModel cita) {		
		
		return this.citService.guardarcita(cita);
	}
	
	@GetMapping(path = "/{id}")   //test con navegador localhost:8080/doctor/id
	public Optional<citasModel> obtenerDoctorById(@PathVariable("id") Long id){
		return this.citService.obtenerPorId(id);
	}

	
	
	@DeleteMapping(path ="/{id}")  //test postman  http://localhost:8080/doctor/id  method:DELET
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.citService.eliminarCita(id);
		if(ok) {
			return "Se elimino correctamente" + id;
		}else {
			return "No se pudo eliminar"+id;
		}
	}

}
