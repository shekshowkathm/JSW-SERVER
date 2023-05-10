package com.jsw.jswserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsw.jswserver.model.Register;

public interface IRegisterRepository extends 
MongoRepository<Register, String>{
	public List<Register> findByEmail(String email);
}
