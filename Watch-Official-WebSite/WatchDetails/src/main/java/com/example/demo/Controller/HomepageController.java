package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.Model.Watch;
import com.example.demo.Service.WatchService;
import org.springframework.ui.Model;

@Controller
public class HomepageController {
	
	@Autowired
	WatchService watchservice;
	
@GetMapping("/")
public String homepage( Model model) {
	List<Watch>watch =watchservice.getallWatch();
	  System.out.println("Number of watches: " + watch.size());
	 model.addAttribute("watch",watch);
	return "home";
}

@GetMapping("/registerPage")
public String showRegisterPage() {
    return "Register"; 
}

@GetMapping("/loginPage")
public String showLoginPage() {
    return "login"; 
}

		

}
