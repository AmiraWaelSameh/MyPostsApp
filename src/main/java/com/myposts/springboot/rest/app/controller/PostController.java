package com.myposts.springboot.rest.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myposts.springboot.rest.app.model.Post;
import com.myposts.springboot.rest.app.model.StatusType;
import com.myposts.springboot.rest.app.model.User;
import com.myposts.springboot.rest.app.service.PostService;

@Controller
@SessionAttributes({ "user", "availableStatuses" })
public class PostController {
	private static final String LIST_POSTS = "list-posts";
	private static final String POSTS_KEY = "posts";
	private static final String SEARCH = "search";
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
		return LIST_POSTS;
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
		if (postContent == null || postContent.trim().isEmpty()) {
			model.put("errorMessage", "Post content cannot be empty.");
		} else {
			Post post = new Post(postContent, StatusType.fromString(selectedStatus),
					new Date(System.currentTimeMillis()), currentUser);
			postService.create(post);
		}
		model.put(POSTS_KEY, postService.retrievePosts(currentUser));
		return LIST_POSTS;
	}

	@GetMapping(value = "/search")
	public String showLoginPage(ModelMap model) {
		User currentUser = getUser(model);
		if (currentUser == null) {
			return LOGIN_REDIRECT;
		}
		return SEARCH;
	}

}
