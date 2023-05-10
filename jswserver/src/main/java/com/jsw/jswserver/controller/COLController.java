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

import com.jsw.jswserver.model.COleakage;
import com.jsw.jswserver.service.ICOLeakage;

@CrossOrigin("*")
@RestController
@RequestMapping("/coleakage")
public class COLController {
	
	@Autowired
	private ICOLeakage colService;
	
	@PostMapping("/save")
	public ResponseEntity<COleakage> addColeakage(@RequestBody COleakage coleakage){
		COleakage saveit=colService.addCol(coleakage);
		return new ResponseEntity<COleakage>(saveit,HttpStatus.CREATED);
		
	}
	@GetMapping("/findall")
	public ResponseEntity<List<COleakage>> getAllCol(){
		List<COleakage> listOfAll=colService.getAllLeakage();
		return new ResponseEntity<List<COleakage>>(listOfAll,HttpStatus.ACCEPTED);
	}
	@GetMapping("/findbyid/{cid}")
	public ResponseEntity<COleakage> getByID(@PathVariable("cid") String cid){
		COleakage listOFLeak=colService.getByID(cid);
		return new ResponseEntity<COleakage>(listOFLeak,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<Void> deleteById(@PathVariable("cid") String cid){
		colService.deleteByID(cid);
		return new ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	@PutMapping("/put/{cid}")
	public ResponseEntity<COleakage> putAnCOL(@RequestBody COleakage coleakage){
		COleakage putit=colService.putAnColCOleakage(coleakage);
		return new ResponseEntity<COleakage>(putit,HttpStatus.ACCEPTED);
	}

}
