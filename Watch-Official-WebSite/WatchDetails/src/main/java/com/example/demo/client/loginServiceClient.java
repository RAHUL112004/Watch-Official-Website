package com.example.demo.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.demo.DTO.Login;
import com.example.demo.DTO.LoginRegister;





@FeignClient(name = "LOGIN-SERVICE", url = "http://localhost:8093")
@EnableFeignClients
public interface loginServiceClient {
	
	 @PostMapping("/Account/register")
	    String Userregister(@RequestBody Login login);

	    @PostMapping("/Account/Login")
	    String userLoginRequest(@RequestBody LoginRegister loginRegister);

	    @GetMapping("/Account/Profile")
	    Object viewProfile(@RequestHeader("Cookie") String session);

		

}
