package com.example.demo.DTO;

import java.util.UUID;

public class Cart {

		 private UUID id;
		 private int productId;
		 private int quantity;
		 private double price;
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
}
