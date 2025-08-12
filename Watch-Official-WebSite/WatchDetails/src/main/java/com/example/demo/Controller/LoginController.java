package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.Login;
import com.example.demo.DTO.LoginRegister;
import com.example.demo.client.loginServiceClient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/Account")
public class LoginController {

	@Autowired
	private loginServiceClient loginserviceclient;
	
	 @PostMapping("/register")
	    @ResponseBody
	    public String registerUser(@RequestBody Login login) {
	        return loginserviceclient.Userregister(login);
	    }

	    @PostMapping("/Login")
	    @ResponseBody
	    public String userLoginRequest(@RequestBody LoginRegister loginRegister, HttpSession session) {
	        String response = loginserviceclient.userLoginRequest(loginRegister);
	        
	        if (response.equalsIgnoreCase("Login successful !")) {
	            session.setAttribute("userEmail", loginRegister.getEmail());
	        }
	        return response;
	    }

	    @GetMapping("/Profile")
	    @ResponseBody
	    public Object viewProfile(HttpServletRequest request) {
	        String cookie = request.getHeader("Cookie");
	        return loginserviceclient.viewProfile(cookie);
	    }
}
