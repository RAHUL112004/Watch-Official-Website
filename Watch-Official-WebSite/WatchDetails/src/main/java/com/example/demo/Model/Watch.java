package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Watch") 
public class Watch {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	private String name;
	private String brand;
	private String description;
	private double price;
	private String imageUrl;
	
	
	  public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Watch(String name, String brand, String description, double price, String imageUrl) {
		super();
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public Watch() {
		super();
		
	}
	
   
	 
}
