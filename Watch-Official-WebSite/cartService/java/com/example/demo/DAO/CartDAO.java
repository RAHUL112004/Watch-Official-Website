package com.example.demo.DAO;



import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart,UUID>{

	Optional<Cart> findById(UUID id);

	

}
