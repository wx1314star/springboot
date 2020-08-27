package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    public String getInfo() {
        return this.restTemplate.getForEntity("http://Server-Provider/info", String.class).getBody();
    }

    @GetMapping("user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/user/{id}").build().expand(params).encode().toUri();
        return this.restTemplate.getForEntity(uri, User.class).getBody();
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
    }
}
