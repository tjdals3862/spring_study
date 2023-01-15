package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
                    @RequestBody Req<User> user,
                     HttpEntity<String> entity,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorzation,
                     @RequestHeader("custom-header") String customHeader
                     ) {
        log.info("client req : {}", user);
        log.info("userId : {}",userId);
        log.info("userName : {}",userName);
        log.info("authorization : {}, custom : {}",authorzation,customHeader);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );

        response.setResBody(user.getResBody());

        return response;
    }
}
