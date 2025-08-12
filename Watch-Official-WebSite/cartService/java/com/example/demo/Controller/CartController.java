package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@PostMapping("/addtocart")
	public String addCart(@RequestBody Cart cart) {
		return cartservice.addToCart(cart);
	}
	
	@DeleteMapping("/removecart/{id}/{productId}")
	public String deleteCart(@PathVariable String id, @PathVariable int productId) {
	    return cartservice.removeCart(UUID.fromString(id), productId);
	}

	
	@GetMapping("/getall")
	public List<Cart> getallitems(){
		return cartservice.getallitem();
		
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAllCarts() {
	    return cartservice.deleteAllCarts(); 
	}
	
	@GetMapping("/total/{id}")
	public double totalCartPrice(@PathVariable String id) {
	    return cartservice.calculateTotalCartPrice(UUID.fromString(id));
	}
}
