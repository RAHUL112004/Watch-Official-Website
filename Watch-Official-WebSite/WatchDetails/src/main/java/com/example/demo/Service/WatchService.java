package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.DAO.Watchdao;
import com.example.demo.Model.Watch;

@Service
public class WatchService {
	
	@Autowired
	Watchdao watchdao;

	
	public String addWatchdata(Watch watch) {
		 watchdao.save(watch);
		 return "Sucess";
	}


	public String updateWatchDetail(int id, Watch watch) {
		 
		Optional<Watch> exitsingWatch= watchdao.findById(id);
		
		if(exitsingWatch.isPresent()) {
			
			Watch newWatch=exitsingWatch.get();
			
			newWatch.setName(watch.getName());
			newWatch.setPrice(watch.getPrice());
			newWatch.setDescription(watch.getDescription());
			newWatch.setBrand(watch.getBrand());
			newWatch.setImageUrl(watch.getImageUrl());
			
			watchdao.save(newWatch);
			return "Sucessfull";
		}
		else {
			return "id not found!";
		}
		
	}


	public String deleteWatches(int id) {
		
		watchdao.deleteById(id);
		return "Sucessfully deleted!";
	}


	public List<Watch> getallWatch() {
	    return  watchdao.findAll();
	}


	public List<Watch> getWatchUsingKeyword(String keyword) {
		if (keyword == null || keyword.isEmpty()) {
	        return watchdao.findAll();  
	    }
		 return watchdao.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword, keyword);
	}
	
	
	

}
