package com.myposts.springboot.rest.app.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myposts.springboot.rest.app.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	Iterable<Post> findAll(Example<Post> probe);
}