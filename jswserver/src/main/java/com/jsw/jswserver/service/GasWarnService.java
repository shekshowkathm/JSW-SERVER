package com.jsw.jswserver.service;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsw.jswserver.model.GasWarn;
import com.jsw.jswserver.repository.IGasWarnRepository;



@Service
public class GasWarnService implements IGasWarnService {
	@Autowired
	private IGasWarnRepository gaswarnrepo;
	
	@Override
	public GasWarn addCOvalues(GasWarn gaswarn) {
		GasWarn save=gaswarnrepo.save(gaswarn);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 String formattedDate = dateFormat.format(currentDate);
		gaswarn.setDate(formattedDate);
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		 String formattedTime = currentTime.format(timeFormatter);
		gaswarn.setTime(formattedTime);
		return gaswarnrepo.save(gaswarn);
	}

	
	@Override
	public GasWarn getByID(String gasid) {
		
		return gaswarnrepo.findById(gasid).get();
	}

	@Override
	public List<GasWarn> getAllValues() {
		
		return gaswarnrepo.findAll();
	}
	@Override
	public void deleteByID(String gasid) {
		gaswarnrepo.deleteById(gasid);
		
	}

}
