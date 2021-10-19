package com.aht.project.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.LoginRequest;
import com.aht.project.service.CustomUserDetailService;

@RestController
public class LoginController {
	 
	@Autowired
	private CustomUserDetailService customUserDetailService;
	/*@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;*/
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping("/login") 
	    public String getLogin(@RequestBody LoginRequest loginRequest) {
		//authenticationManagerBuilder
		 try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return "login fail";
		}
		  UserDetails userDetails  = customUserDetailService.loadUserByUsername(loginRequest.getUsername());
	        return "login";
	    }
	
}
