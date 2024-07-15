package com.example.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.consultoriosModel;

@Repository
public interface consultorioRepository extends CrudRepository<consultoriosModel, Long> {


}
