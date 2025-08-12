package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.cartServiceClient;
import com.example.demo.DTO.Cart;

@RestController
@RequestMapping("/Cart")
public class CartController {

    @Autowired
    private cartServiceClient cartServiceClient;

    @PostMapping("/addtocart")
    public String addToCart(@RequestBody Cart cart) {
        return cartServiceClient.addCart(cart);
    }

    @DeleteMapping("/removecart/{id}/{productId}")
    public String removeFromCart(@PathVariable UUID userId, @PathVariable int productId) {
        return cartServiceClient.deleteCart(userId.toString(), productId);
    }

    @GetMapping("/total{id}")
    public double getTotal(@PathVariable UUID userId) {
        return cartServiceClient.totalCartPrice(userId);
    }
}
