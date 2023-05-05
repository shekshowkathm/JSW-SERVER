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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsw.jswserver.model.Register;
import com.jsw.jswserver.service.IRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IRegisterService regService;
	
	@PostMapping("/save")
	public ResponseEntity<Register> addRegister(@RequestBody Register register){
		Register saveit=regService.addRegister(register);
		return new ResponseEntity<Register>(saveit,HttpStatus.CREATED);
		
	}
	@GetMapping("/findall")
	public ResponseEntity<List<Register>> getAllRegister(){
		List<Register> listOfAllReg=regService.getAllRegister();
		return new ResponseEntity<List<Register>>(listOfAllReg,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/findbyid/{rid}")
	public ResponseEntity<Register> getById(@PathVariable("rid") String rid){
		Register listByID=regService.getByID(rid);
		return new ResponseEntity<Register>(listByID,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{rid}")
	public ResponseEntity<Void> deleteByid(@PathVariable("rid") String rid){
		regService.deleteByID(rid);
		return new ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY);
		
		
	}
	@PutMapping("/put/{rid}")
	public ResponseEntity<Register> putAnReg(@RequestBody Register register){
		Register putit=regService.putAnRegister(register);
		return new ResponseEntity<Register>(putit,HttpStatus.OK);
		
	}
	
	
}

