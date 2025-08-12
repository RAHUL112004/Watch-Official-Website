package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Login;
import com.example.demo.UserDao.loginDao;

@Service
public class loginService {
	
	@Autowired
	private loginDao loginDao;

	public Login register(Login login) {
	    try {
	        if (loginDao.findByEmail(login.getEmail()) != null) {
	            throw new RuntimeException("Email already exists");
	        }
	        return loginDao.save(login);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}


	public boolean validateUser(String email, String password) {
		
		Login user = loginDao.findByEmail(email);
	   if(user!=null && user.getPassword().equals(password)) {
		   return true;
	   }
		
	   return false;
	}

	public  Login getUserByEmail(String email) {
		
		return loginDao.findByEmail(email);
	}

}
