package com.codewitharjun.fullstack_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
	@Autowired
	private JpaRepsitory jpaRepsitory;
	
	@PostMapping("/users")
	User newuser(@RequestBody User newUser ) {
		return jpaRepsitory.save(newUser);
	}
	@GetMapping("/getUsers")
	List<User>getdata(){
		return jpaRepsitory.findAll();
	}
	  @GetMapping("/demo/{id}")
	    Optional<User> getUserById(@PathVariable Long id) {
	        return jpaRepsitory.findById(id);
	              
	    }
	  
	  @PutMapping("/update/{id}") // Use curly braces for path variables
	  Optional<User> updateUser(@RequestBody User requestBody, @PathVariable Long id) {
	      return jpaRepsitory.findById(id).map(user -> {
	          user.setUserName(requestBody.getUserName());
	          user.setEmail(requestBody.getEmail());
	          user.setName(requestBody.getName());
	          return jpaRepsitory.save(user);
	      });
	  }
	  @DeleteMapping("/user/{id}")
	  String deleteUser(@PathVariable Long id){
		  jpaRepsitory.deleteById(id);
		return  "User with id "+id+" has been deleted success.";
	  }

	  

}
