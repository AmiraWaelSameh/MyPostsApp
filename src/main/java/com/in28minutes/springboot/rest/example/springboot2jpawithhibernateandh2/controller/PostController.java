package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.Post;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.StatusType;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.User;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.service.PostService;

@Controller
@SessionAttributes({ "user", "availableStatuses" })
public class PostController {
	private static final String POSTS_KEY = "posts";
	private static final String SEARCH_REDIRECT = "search";
	private static final String LOGIN_REDIRECT = "redirect:/login";
	@Autowired
	PostService postService;

	@Autowired
	PostService searchService;

	@GetMapping(value = "/list-posts")
	public String showPosts(ModelMap model) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		model.put(POSTS_KEY, postService.retrievePosts(currentUser));
		model.put("availableStatuses", postService.getAvailableStatuses());
		return "list-posts";
	}

	private User getUser(ModelMap model) {
		if (!model.containsKey("user") || model.get("user") == null) {
			return null;
		}
		return (User) model.get("user");
	}

	@PostMapping(value = "/list-posts")
	public String addPost(ModelMap model, @RequestParam String postContent, @RequestParam String selectedStatus) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		Post post = new Post(postContent, StatusType.fromString(selectedStatus), new Date(System.currentTimeMillis()),
				currentUser);
		postService.create(post);
		model.put(POSTS_KEY, postService.retrievePosts(currentUser));
		return "list-posts";
	}

	@GetMapping(value = "/search")
	public String showLoginPage(ModelMap model) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		return SEARCH_REDIRECT;
	}

	@PostMapping(value = "/search")
	public String searchPublicPosts(ModelMap model, @RequestParam String searchContent) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		if (searchContent == null || searchContent.trim().isEmpty()) {
			model.put("errorMessage", "Search words cannot be empty.");
			return SEARCH_REDIRECT;
		}
		List<Post> result = new ArrayList<>();
		searchService.searchPublicPosts(searchContent).forEach(result::add);
		model.put(POSTS_KEY, result);
		if (result.isEmpty()) {
			model.put("emptySearchMessage", "No posts matched your search keywords.");
		}

		return SEARCH_REDIRECT;
	}
}
