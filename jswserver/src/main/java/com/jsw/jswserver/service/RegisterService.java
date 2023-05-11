package com.jsw.jswserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsw.jswserver.model.Register;
import com.jsw.jswserver.repository.IRegisterRepository;



@Service
public class RegisterService implements IRegisterService{
	
	@Autowired
	private IRegisterRepository regRepo;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	@Autowired
	private final JavaMailSender mailSender;
	
	public RegisterService(IRegisterRepository regRepo,PasswordEncoder passwordencoder,JavaMailSender mailSender) {
		this.regRepo= regRepo;
		this.passwordencoder=passwordencoder;
		this.mailSender=mailSender;
	}

	@Override
	public Register addRegister(Register register) {
		register.setRole("USER");
		register.setPassword(passwordencoder.encode(register.getPassword()));
		register.setId(register.getEmail());
		
		Register save=regRepo.save(register);
		return save;
	}

	@Override
	public List<Register> getAllRegister() {
		
		return regRepo.findAll();
	}

	@Override
	public Register getByID(String regid) {
		// TODO Auto-generated method stub
		return regRepo.findById(regid).get();
	}

	@Override
	public void deleteByID(String regid) {
		regRepo.deleteById(regid);
		
	}

	@Override
	public Register putAnRegister(Register register) {
		Register putit=regRepo.save(register);
		return putit;
	}
	@Override
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);

		}
	@Override
	public void sendAlert(Register register) {
		String subject="Warning!!";
		String text="High PPM alert ";
		sendEmail(register.getEmail(),subject,text);
		
		
		
	}

}
