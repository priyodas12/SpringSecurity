package com.workspace.SpringSecurity.root;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomePageController {
	
	@GetMapping("/greet/users")
	public String greetUser() {
		return "<h1>Hello User</h1>";
	}
	
	@GetMapping("/greet/admin")
	public String greetAdmin() {
		return "<h1>Hello Admin</h1>";
	}
}
