package com.erichgamma.api.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.team.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String>{
    
}
