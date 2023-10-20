package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Environment env;

    @RequestMapping("health-check")
    public String healthCheck(){
        return "server is available!";
    }

    @PostMapping("users")
    public ResponseEntity<?> createUser(@Valid @RequestBody RequestCreateUserDto userDto){
        userService.createUser(userDto);
        return ResponseEntity.ok("회원 가입 완료!");
    }

    @GetMapping("{uuid}")
    public ResponseEntity<?> findUser(@PathVariable String uuid){
        ResponseFindUserDto userDto = userService.findUser(uuid);
        return ResponseEntity.ok(userDto.toString());
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("port-check")
    public String portCheck(){
        return env.getProperty("local.server.port")
                + "/"
                + env.getProperty("test.value");
    }
}
