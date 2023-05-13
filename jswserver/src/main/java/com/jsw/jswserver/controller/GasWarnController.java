package com.jsw.jswserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsw.jswserver.model.GasWarn;

import com.jsw.jswserver.service.IGasWarnService;

@CrossOrigin("*")
@RestController
@RequestMapping("/gaswarn")
public class GasWarnController {
	@Autowired
	private IGasWarnService gaswarnservicerepo;
	
	@PostMapping("/save")
	public ResponseEntity<GasWarn> addCOvalues(@RequestBody GasWarn gaswarn){
		GasWarn saveit=gaswarnservicerepo.addCOvalues(gaswarn);
		return new ResponseEntity<GasWarn>(saveit,HttpStatus.CREATED);
		
	}
	@GetMapping("/showAll")
	public ResponseEntity<List<GasWarn>> getAllValues(){
		List<GasWarn> listOfAllValues=gaswarnservicerepo.getAllValues();
		return new ResponseEntity<List<GasWarn>>(listOfAllValues,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/findbyid/{rid}")
	public ResponseEntity<GasWarn> getById(@PathVariable("rid") String rid){
		GasWarn listByID=gaswarnservicerepo.getByID(rid);
		return new ResponseEntity<GasWarn>(listByID,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{rid}")
	public ResponseEntity<Void> deleteByid(@PathVariable("rid") String rid){
		gaswarnservicerepo.deleteByID(rid);
		return new ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY);
	
}
}
