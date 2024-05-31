package com.athenas.appback.services;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	/*private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }*/
    public ApplicationUserDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        
    	String name = "admin";
    	String pass = bCryptPasswordEncoder.encode("admin123");
    	
        if (!username.equals(name)) {
            throw new UsernameNotFoundException(username);
        }
        return new User(name, pass, emptyList());
    }
}