package com.jsw.jswserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsw.jswserver.model.COleakage;
import com.jsw.jswserver.repository.ICOLeakageRepository;

@Service
public class COLeakageService implements ICOLeakage{
	
	@Autowired
	private ICOLeakageRepository colRepo;
	
	@Override
	public COleakage addCol(COleakage coleakage) {
		COleakage save=colRepo.save(coleakage);
		return save;
	}

	@Override
	public List<COleakage> getAllLeakage() {
		
		return colRepo.findAll();
	}

	@Override
	public COleakage getByID(String colid) {
		// TODO Auto-generated method stub
		return colRepo.findById(colid).get();
	}

	@Override
	public void deleteByID(String colid) {
		colRepo.deleteById(colid);
		
	}

	@Override
	public COleakage putAnColCOleakage(COleakage coleakage) {
		COleakage put=colRepo.save(coleakage);
		return put;
	}

}
