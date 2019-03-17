package com.myposts.springboot.rest.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myposts.springboot.rest.app.model.Post;
import com.myposts.springboot.rest.app.service.PostService;

@RestController
public class SearchController {
	@Autowired
	PostService searchService;

	@GetMapping(value = "/search/{searchContent}")
	public List<Post> searchPublicPosts(@PathVariable String searchContent) {
		List<Post> result = new ArrayList<>();
		if (searchContent != null && !searchContent.trim().isEmpty()) {
			searchService.searchPublicPosts(searchContent).forEach(result::add);
		} else {
			throw new RuntimeException("search cannot be empty");
		}
		return result;
	}
}
