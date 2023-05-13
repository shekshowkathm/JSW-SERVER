package com.jsw.jswserver.service;

import java.util.List;

import com.jsw.jswserver.model.Register;

public interface IRegisterService {
	
	public Register addRegister(Register register);
	public List<Register> getAllRegister();
	public Register getByID(String regid);
	public void deleteByID(String regid);
	public Register putAnRegister(Register register);
	public Register updatePassword(Register register, String email);
	public List<Register> getRegisterByEmail(String email);

}
