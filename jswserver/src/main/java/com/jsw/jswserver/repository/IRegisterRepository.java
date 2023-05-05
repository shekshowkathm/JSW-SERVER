package com.jsw.jswserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsw.jswserver.model.Register;

public interface IRegisterRepository extends 
MongoRepository<Register, String>{

}
