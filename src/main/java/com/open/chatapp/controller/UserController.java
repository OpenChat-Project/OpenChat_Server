package com.open.chatapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.chatapp.dto.UserDTO;

@RestController
@RequestMapping("user")
public class UserController {
	
	@GetMapping("/login")
	public UserDTO login(String userId, int userPw) {
		UserDTO user = new UserDTO();
		return user;
	}
}
