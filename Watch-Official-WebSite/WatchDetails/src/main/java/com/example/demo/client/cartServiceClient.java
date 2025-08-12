package com.example.demo.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.Cart;

@FeignClient(name = "CART-SERVICE",url = "http://localhost:8095")
public interface cartServiceClient {
	
	@PostMapping("/Cart/addtocart")
	public String addCart(@RequestBody Cart cart);
	

	  @DeleteMapping("/Cart/removecart/{id}/{productId}")
	   String deleteCart(@PathVariable("id") String id, @PathVariable("productId") int productId);
	
	@GetMapping("/Cart/total/{id}")
	public double totalCartPrice(@PathVariable UUID id);

}
