package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.UserDTO;
import com.cdac.entity.User;
import com.cdac.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("welcome")
	public String greetUser(@RequestParam String userName) {
		System.out.println(userName);
		return "<h1 style='text-align:center;color:green;'>Welcome " + userName + " !!</h1>";
	}
	
	@GetMapping("getAllUsers")
	public List<User> getUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping("getUsers")
	public List<User> getUsers(@RequestParam int pageNo, @RequestParam int pageSize) {
		return userService.getUsers(pageNo-1,pageSize);
	}
	
	@PostMapping("login")
	public String getUser(@RequestBody UserDTO userDTO) {
		return userService.getUser(userDTO.getUsername(),userDTO.getPassword()) 
				? "Welcome " + userDTO.getUsername() + " !!" 
				: "Incorrect username or password";
	}
	
	@PostMapping("addUser")
	public String addUser(@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO) ? "User saved successfully !!!" : "User could not be saved";
	}

	@DeleteMapping("deleteUser/{username}")
	public String deleteUser(@PathVariable String username) {
		return userService.deleteUser(username) ? "User deleted successfully !!!" : "User could not be deleted";
	}
	
	@PutMapping("updateUser")
	public String updateUser(@RequestBody UserDTO userDTO) {
		return userService.updateUser(userDTO); 
//				? "User updated successfully !!!" : "User could not be updated";
	}
	
}