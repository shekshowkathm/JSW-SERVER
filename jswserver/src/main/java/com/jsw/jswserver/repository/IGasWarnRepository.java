package com.jsw.jswserver.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jsw.jswserver.model.GasWarn;
import com.jsw.jswserver.model.Register;


@Repository
public interface IGasWarnRepository extends 
MongoRepository<GasWarn, String>{
	
}