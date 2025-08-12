package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Watch;

@Repository
public interface Watchdao extends JpaRepository<Watch,Integer>{

	List<Watch> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand);

	

}
