package com.erichgamma.api.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.erichgamma.api.common.component.MessengerVo;
import com.erichgamma.api.common.component.security.JwtProvider;
import com.erichgamma.api.user.model.User;
import com.erichgamma.api.user.model.UserDto;
import com.erichgamma.api.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

// @Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;
    // -------------------------- Command -------------------------- 

    @Override
    public MessengerVo save(UserDto userDto) {
        return MessengerVo.builder()
        .message(
            Stream.of(userDto)
            .filter(i -> !userRepository.existsByUsername(userDto.getUsername()))
            .peek(i -> userRepository.save(dtoToEntity(i)))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo modify(UserDto userDto) {
        return MessengerVo.builder()
        .message(
            findUserByUsername(userDto.getUsername()).stream()
            .peek(i -> i.setPassword(userDto.getPassword()))
            .peek(i -> i.setName(userDto.getName()))
            .peek(i -> i.setPhone(userDto.getPhone()))
            .peek(i -> i.setJob(userDto.getJob()))
            .peek(i -> userRepository.save(i))
            .map(i -> "SUCCESS").findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo insertMany() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMany'");
    }

    @Override
    public MessengerVo deleteById(Long id) {
        return MessengerVo.builder()
        .message(
            Stream.of(id)
            .filter(i -> userRepository.existsById(i))
            .peek(i -> userRepository.deleteById(i))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo deleteAll() {
        userRepository.deleteAll();
        return MessengerVo.builder()
        .message("SUCCESS")
        .build();
    }

    // -------------------------- Query -------------------------- 

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
        .stream()
        .map(i -> entityToDto(i))
        .toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(i -> entityToDto(i));
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Transactional
    @Override
    public MessengerVo login(UserDto userDto){
        return findUserByUsername(userDto.getUsername()).stream()
        .filter(i -> i.getPassword().equals(userDto.getPassword()))
        .map(i -> List.of(i.getId(), jwtProvider.createToken(entityToDto(i))))
        .peek(i -> userRepository.modifyTokenById((Long)i.get(0), (String)i.get(1)))
        .map(i -> MessengerVo.builder().message("SUCCESS").accessToken((String)i.get(1)).build())
        .findAny().orElseGet(() -> MessengerVo.builder().message("FAILURE").accessToken("").build());
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        return userRepository.findByName(name).stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return userRepository.findByJob(job).stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public MessengerVo existsByUsername(String username) {
        return MessengerVo.builder().message(userRepository.existsByUsername(username) ? "SUCCESS" : "FAILURE").build();
    }

    @Transactional
    @Override
    public MessengerVo logout(String accessToken) {    
        return MessengerVo.builder()
        .message(
            Stream.of(accessToken)
            .filter(i -> i.startsWith("Bearer "))
            .map(i -> jwtProvider.getPayload(i.substring(7)).get("userid", Long.class))
            .filter(i -> userRepository.existsById(i))
            .peek(i -> userRepository.modifyTokenById(i, null))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }
}
