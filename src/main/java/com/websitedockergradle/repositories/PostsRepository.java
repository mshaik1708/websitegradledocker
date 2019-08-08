package com.websitedockergradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitedockergradle.model.Posts;



public interface PostsRepository extends JpaRepository<Posts, Long> {

}
