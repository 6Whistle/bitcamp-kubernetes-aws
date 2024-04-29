package com.erichgamma.api.stadium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.stadium.model.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
