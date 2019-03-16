package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.Post;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.StatusType;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model.User;
import com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepo;

	public Iterable<Post> retrievePosts(User user) {
		Post probe = new Post();
		probe.setUser(user);
		return postRepo.findAll(Example.of(probe));
	}

	public Post create(Post newPost) {
		return postRepo.save(newPost);
	}

	public List<String> getAvailableStatuses() {
		List<String> availableStatuses = new ArrayList<>();
		Arrays.asList(StatusType.values()).stream().forEach(st -> availableStatuses.add(st.getValue()));
		return availableStatuses;
	}

	public Iterable<Post> searchPublicPosts(String search) {
		List<Post> posts = new ArrayList<>();
		Post probe = new Post();
		probe.setStatus(StatusType.PUBLIC);
		postRepo.findAll(Example.of(probe)).forEach(posts::add);
		return posts.stream().filter(post -> post.getContent().contains(search)).collect(Collectors.toList());
	}
}