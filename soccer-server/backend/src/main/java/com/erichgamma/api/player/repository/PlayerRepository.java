package com.erichgamma.api.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.player.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
}
