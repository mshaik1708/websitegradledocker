package com.websitedockergradle.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.websitedockergradle.model.Posts;
import com.websitedockergradle.service.PostsService;





@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	private static Logger logger = LogManager.getLogger();
	@Autowired
    private PostsService postsService;

	@GetMapping("/getAllPosts")
    @ResponseBody
//    @PreAuthorize("hasRole('ROLE_OAUTH_ADMIN')")
    public ResponseEntity<Map<String,Object>> getAllPosts(){
        List<Posts> posts =  postsService.getAllPosts();
        Map<String,Object> postsMap = new HashMap<String,Object>();
        postsMap.put("posts",posts);
        logger.info("Returning the array of posts"+postsMap.get("posts"));
        return new ResponseEntity<Map<String,Object>>(postsMap, HttpStatus.OK);
    }
    
	@GetMapping("/getPost/{id}")
    @ResponseBody
    public ResponseEntity<Object> getPost(@PathVariable long id){
    	Optional<Posts> postsOptional = postsService.getPostbyId(id);
    	if (!postsOptional.isPresent()) {
    		Map<String,String> response = new HashMap<String,String>();
			response.put("response","Post not found");
    		return new ResponseEntity<Object>( response, HttpStatus.NOT_FOUND);
    	}
    	logger.info("Returning post"+postsOptional.get().toString());
    	return new ResponseEntity<Object>(postsOptional.get(), HttpStatus.OK);
    }
	
	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable long id) {
		postsService.deletePost(id);
		Map<String,String> response = new HashMap<String,String>();
		response.put("response","Deleted the Post");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PostMapping("/newPost")
	public ResponseEntity<Object> createPost(@RequestBody Posts post) {
		Posts savedPost = postsService.createPost(post);
		
		Map<String,String> response = new HashMap<String,String>();
		response.put("response","created new post"+savedPost.toString());
		return new ResponseEntity<Object>( response, HttpStatus.OK);

	}
	
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<Object> updatePosts(@RequestBody Posts post, @PathVariable long id) {
		postsService.updatePost(post, id);
		Map<String,String> response = new HashMap<String,String>();
		response.put("response","updated post by "+post.getAuthor());
		return new ResponseEntity<Object>( response, HttpStatus.OK);
	}

}
