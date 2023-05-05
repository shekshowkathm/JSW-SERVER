package com.jsw.jswserver.service;

import java.util.List;

import com.jsw.jswserver.model.COleakage;

public interface ICOLeakage {
	
	public COleakage addCol(COleakage coleakage);
	public List<COleakage> getAllLeakage();
	public COleakage getByID(String colid);
	public void deleteByID(String colid);
	public COleakage putAnColCOleakage(COleakage coleakage);

}
