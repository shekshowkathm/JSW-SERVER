package com.jsw.jswserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import com.jsw.jswserver.model.GasWarn;
import com.jsw.jswserver.model.Register;
import com.jsw.jswserver.repository.IGasWarnRepository;
import com.jsw.jswserver.repository.IRegisterRepository;
import java.time.format.DateTimeFormatter;



@Service
public class RegisterService implements IRegisterService{
	
	@Autowired
	private IRegisterRepository regRepo;
	private IGasWarnRepository gaswarnRepo;
	
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
	public Register updatePassword(Register register, String email) {
		Register Obj = regRepo.findByEmail(email).get(0);
		Obj.setPassword(passwordencoder.encode(register.getPassword()));
		return regRepo.save(Obj);

	}
	@Override
	public List<Register> getRegisterByEmail(String email) {
		if (regRepo.findByEmail(email) != null) {
			return regRepo.findByEmail(email);
		}
		return null;

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
	public void sendAlert(GasWarn gasWarn) {
		System.out.println(gasWarn.getPpm());
		System.out.println(gasWarn.getLocation());
		System.out.println(gasWarn.getEmail());
		
		// Get the current local time
        LocalTime currentTime = LocalTime.now();
        //get current date
        LocalDate currentDate = LocalDate.now();

        // Print the current local time
        System.out.println("Current local time: " + currentTime);
        
        String currentTimeString = currentTime.toString();
        
        gasWarn.setTime(currentTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        gasWarn.setDate(formattedDate);
		
		String subject="🚨🚨🚨🚨🚨🚨🚨 Warning!!🚨🚨🚨🚨🚨🚨🚨🚨🚨";
		String text="High PPM alert ☠☠☠☠"+gasWarn.getPpm()+"☠☠☠☠☠ at the location  🧭🧭🧭" +gasWarn.getLocation()+"🧭🧭🧭" +  " 🕰🕰🕰🕰🕰🕰🕰 "+""+gasWarn.getTime()+"🕰🕰🕰🕰🕰🕰🕰" +""+ " 📆📆📆📆📆📆📆"+""+gasWarn.getDate() +" 📆📆📆📆📆📆📆 ";
		sendEmail(gasWarn.getEmail(),subject,text);
	}

}
