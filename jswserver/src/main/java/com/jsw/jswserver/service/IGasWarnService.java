package com.jsw.jswserver.service;

import java.util.List;

import com.jsw.jswserver.model.GasWarn;



public interface IGasWarnService {
	public GasWarn addCOvalues(GasWarn gaswarn);
	public List<GasWarn> getAllValues();
	public GasWarn getByID(String gasid);
	public void deleteByID(String gasid);

	
	
}
