package com.example.demo.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Login;

@Repository
public interface loginDao extends JpaRepository<Login,Long>{

	Login findByEmail(String email);	

	

}
