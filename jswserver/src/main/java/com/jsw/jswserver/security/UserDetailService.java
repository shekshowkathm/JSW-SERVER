package com.jsw.jswserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jsw.jswserver.repository.IRegisterRepository;



@Component
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private IRegisterRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return registerRepository.findById(username)
				.map(UserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
	}

}
