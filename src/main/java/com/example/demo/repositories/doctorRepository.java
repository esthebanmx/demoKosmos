package com.example.demo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.doctoresModel;

@Repository
public interface doctorRepository extends CrudRepository<doctoresModel, Long>{
	
}
