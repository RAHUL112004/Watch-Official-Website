package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.UUID;

@Entity
public class Cart {
    
	@Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "VARCHAR(36)")
	 private UUID id;
	
	 @Column(nullable = false)
	 private int productId;
	 @Column(nullable = false)
	 private int quantity;
	 @Column(nullable = false)
	 private double price;
	 @Transient
	    private String productName;
	 
	 
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }
	    
	@Override
	public String toString() {
		return "cart [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", price=" + price
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	 
	 
}
