package com.erichgamma.api.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.board.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Boolean existsByTitle(String boardType);

    Optional<Board> findByTitle(String boardType);
    
}