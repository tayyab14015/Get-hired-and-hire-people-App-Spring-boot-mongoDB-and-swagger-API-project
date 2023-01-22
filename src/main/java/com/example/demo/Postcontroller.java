package com.example.demo;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins ="http://localhost:3000")

@RestController
public class Postcontroller {
	@Autowired
	Postrepository repo;
	@Autowired
	searching s1;
	@RequestMapping(value="/")
public void swagger(HttpServletResponse  response) throws IOException {
	response.sendRedirect("/swagger-ui.html");
}
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return s1.findbytext(text);
    }
    
    @PostMapping("/post")
    public Post setAllPosts(@RequestBody Post post)
    {
        return repo.save(post);
    }
    
    
}
