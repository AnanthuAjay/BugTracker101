package com.ust.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.user.entity.User;
import com.ust.user.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception
	{
		System.out.println(user.getUsername());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getRole());
		
		String tempUsername=user.getUsername();
		if(tempUsername != null && tempUsername!="") {
			User userobj = userService.getUserByUsername(tempUsername);
			if(userobj != null ) {
				throw new Exception("user with "+tempUsername+" already exists");
			}
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
			
		User user2 = new User(user.getName(), user.getUsername(), encodedPassword, user.getEmail(),user.getRole());
		
		
		User registerUser = userService.registerUser(user2);
		return new ResponseEntity<User>(registerUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logIn(@RequestBody User user)
	{
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		User user1 = userService.getUserByUsername(user.getUsername());
		Boolean b = BCrypt.checkpw(user.getPassword(), user1.getPassword());
		if(b==true) {
			
			
			String token = Jwts.builder().setId(user1.getUsername()).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "usersecretkey").compact();
			
			Map<String, String> tokenMap = new HashMap<String, String>();
			tokenMap.put("token", token);
			tokenMap.put("message", "User Successfully logged in");
			ResponseEntity<Map<String, String>> response = new ResponseEntity<Map<String, String>>(tokenMap, HttpStatus.OK);
			
			return response;
		}
		else {
			
			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}
		
		
	}

}
