package com.jsw.jswserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsw.jswserver.model.COleakage;

public interface ICOLeakageRepository extends MongoRepository<COleakage, String>{

}
