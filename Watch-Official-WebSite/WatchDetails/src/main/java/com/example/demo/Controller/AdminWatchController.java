package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Watch;
import com.example.demo.Service.WatchService;

@RestController
@RequestMapping("admin")
public class AdminWatchController {
	
	@Autowired
	WatchService watchservice;
	
	
	@PostMapping("/add")
	public String addWatch(@RequestBody Watch watch){
		return watchservice.addWatchdata(watch);
	}
	
	@PutMapping("/update/{id}")
	public String updateWatch(@PathVariable int id , @RequestBody Watch watch) {
		return  watchservice.updateWatchDetail(id,watch);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteWatch(@PathVariable int id) {
		return watchservice.deleteWatches(id);
	}

}
