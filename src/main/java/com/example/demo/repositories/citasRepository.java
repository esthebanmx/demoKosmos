package com.example.demo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.citasModel;

@Repository
public interface citasRepository extends CrudRepository<citasModel, Long>{
	
}