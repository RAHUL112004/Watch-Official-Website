package com.example.demo.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CartDAO;
import com.example.demo.Model.Cart;

@Service
public class CartService {
	
	@Autowired
	private CartDAO cartdao;

	public  String addToCart(Cart cart) {
		 cartdao.save(cart);
		 return "success";
	}

	public String removeCart(UUID id, int productId) {
		  Optional<Cart> cartitem=cartdao.findById(id);
		  
		  if(cartitem.isPresent()) {
			  Cart cart=cartitem.get();
			  
			  if(cart.getProductId()==productId) {
				  cartdao.deleteById(id);
				  return "Removed successfull";
			  }
			  else {
				  return "not success";
			  }
		  }
		  else {
			  return "product not found";
		  }
		
	}

	public List<Cart> getallitem() {
		return cartdao.findAll();
	}
	
	public String deleteAllCarts() {
	    cartdao.deleteAll();
	    return "All carts deleted";
	}

	public double calculateTotalCartPrice(UUID Id) {
	    System.out.println("Looking for cart ID: " + Id);
	    Optional<Cart> cartItem = cartdao.findById(Id);
	    if (cartItem.isPresent()) {
	        Cart item = cartItem.get();
	        return item.getPrice() * item.getQuantity();
	    } else {
	        System.out.println("Cart not found for ID: " + Id);
	        return 0.0;
	    }
	}


	


}
