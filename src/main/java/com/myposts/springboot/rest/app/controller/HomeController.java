package com.myposts.springboot.rest.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myposts.springboot.rest.app.model.User;
import com.myposts.springboot.rest.app.service.PostService;
import com.myposts.springboot.rest.app.service.UserService;

@Controller
@SessionAttributes("user")
public class HomeController {
	private static final String LOGIN_REDIRECT = "redirect:/login";

	@Autowired
	UserService service;

	@Autowired
	PostService postService;

	@GetMapping(value = "/login")
	public String showLoginPage(ModelMap model) {
		return "/login";
	}

	@PostMapping(value = "/login")
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		User result = service.validateUser(name, password);

		if (result == null) {
			model.put("errorMessage", "Invalid Credentials");
			return "/login";
		}

		model.put("user", result);

		return "home";
	}

	@GetMapping("/home")
	public String backToWelcomePage(ModelMap model) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		return "home";
	}

	private User getUser(ModelMap model) {
		if (!model.containsKey("user") || model.get("user") == null) {
			return null;
		}
		return (User) model.get("user");
	}
}