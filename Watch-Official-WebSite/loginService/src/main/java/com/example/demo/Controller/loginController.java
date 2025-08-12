package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginRequest;
import com.example.demo.Model.Login;
import com.example.demo.Service.loginService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/Account")
public class loginController {
     
	@Autowired
	private loginService loginservice;
	
	@PostMapping("/register")
	public ResponseEntity<String> userregister(@RequestBody Login login) {
	    try {
	        System.out.println("Received: " + login);
	        loginservice.register(login);
	        return ResponseEntity.ok("Registration successful!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Error: " + e.getMessage());
	    }
	}

	
	@PostMapping("/Login")
	public String userLoginRequest(@RequestBody LoginRequest loginRequest,HttpSession session) {
		
		boolean isValid=loginservice.validateUser(loginRequest.getEmail(),loginRequest.getPassword());
		
		  if(isValid) {
			  session.setAttribute("userEmail", loginRequest.getEmail());
			  return "Login successful !";
		  }
		  else {
			  return "Invalid email or password!";
		  }
	}
	
	@GetMapping("/Profile")
	public Object viewProfile(HttpSession session) {
	    try {
	        String email = (String) session.getAttribute("userEmail");
	        System.out.println("Session email: " + email);

	        if (email == null) {
	            return "Please login first.";
	        }

	        Login user = loginservice.getUserByEmail(email);
	        System.out.println("Fetched user: " + user);

	        if (user == null) {
	            return "User not found.";
	        }

	        return user;

	    } catch (Exception e) {
	        e.printStackTrace(); // Log the full error to console
	        return "An error occurred: " + e.getMessage(); // Help diagnose
	    }
	}
}
