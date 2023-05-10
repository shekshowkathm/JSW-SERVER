package com.jsw.jswserver.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JWTController {
	
	private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public JWTController(JWTService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
    	
    }
    
    @PostMapping("/login")
    public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
    	System.out.println(authRequest);
    	 Authentication authentication = authenticationManager
                 .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
         if (authentication.isAuthenticated()){
             return jwtService.generateToken(authRequest.getUserName());
         }
         else {
        	 return "NO founded";
         }
    }

}
