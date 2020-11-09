package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;

    // 생성자를 통한 의존성 주입
    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // GET, /users/1 or /users/10 -> 서버측에 전달할때 String이 기본
    @GetMapping("/users/{id}")          // int로 선언하면 자동 형변환(String -> int)
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = service.save(user);
    }
}
