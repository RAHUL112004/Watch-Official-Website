package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Watch;
import com.example.demo.Service.WatchService;

@RestController
@RequestMapping("user")
public class userWatchController {
	
	   @Autowired
	   WatchService watchservice;
	
	@GetMapping("/allWatch")
	public List<Watch> getAllWatch(){
		return watchservice.getallWatch();
	}
	
	@GetMapping("/search")
	public List<Watch> getWatchByKeyword(@RequestParam String keyword){
		return watchservice.getWatchUsingKeyword(keyword);
	}
	

}
