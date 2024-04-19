package com.erichgamma.api.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    List<User> findByName(String name);
    List<User> findByJob(String job);

    @Modifying
    @Query("UPDATE users u SET u.token = :userToken WHERE u.id = :userId")
    void modifyTokenById(@Param("userId") Long id, @Param("userToken") String token);
}
