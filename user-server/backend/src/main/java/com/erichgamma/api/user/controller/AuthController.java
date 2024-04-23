package com.erichgamma.api.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erichgamma.api.common.component.MessengerVo;
import com.erichgamma.api.user.model.UserDto;
import com.erichgamma.api.user.service.UserService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApiResponses(value = {
    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
    @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
@Slf4j
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<MessengerVo> login(@RequestBody UserDto userDto){
        log.info("login request : {}", userDto);
        return ResponseEntity.ok(userService.login(userDto));
    }

    @GetMapping("/exist-username")
    public ResponseEntity<MessengerVo> existByUsername(@RequestParam("username") String username){
        log.info("existByUsername request : {}", username);
        return ResponseEntity.ok(userService.existsByUsername(username));
    }
}