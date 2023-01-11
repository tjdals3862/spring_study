package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User2;
import org.apache.catalina.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResApiController {

    @GetMapping("get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping("/post")
    public User2 post(@RequestBody User2 user2) {

        return user2;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic
        Thread.sleep(1000*2);

    }

    @Decode
    @PutMapping("/put")
    public User2 put(@RequestBody User2 user2) {
        System.out.println("put");
        System.out.println(user2);
        return user2;
    }
}
