package com.erichgamma.api.common.security.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.erichgamma.api.common.component.MessengerVo;
import com.erichgamma.api.user.model.UserDto;
import com.erichgamma.api.user.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    @Override
    public MessengerVo login(UserDto userDto){
        Boolean flag = userRepository.findByUsername(userDto.getUsername()).get().getPassword().equals(userDto.getPassword());
        return MessengerVo.builder()
        .message(
            flag ? "SUCCESS" : "FAILURE"
        )
        .accessToken(flag ? createToken(userDto) : "")
        .build();
    }

    @Override
    public String createToken(UserDto user) {
        return Jwts.builder()
        .claims()
        .issuer("erichgamma.co.kr")
        .subject("User Auth")
        .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
        .add("userId", user.getId())
        .add("username", user.getUsername())
        .add("job", "admin")
        .and()
        .compact()
        ;
    }
}
