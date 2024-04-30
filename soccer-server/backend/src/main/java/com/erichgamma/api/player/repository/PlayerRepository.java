package com.erichgamma.api.player.repository;

import com.erichgamma.api.player.model.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.player.model.Player;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{


    @Query("SELECT DISTINCT new map(p.position AS POSITION) FROM player p")
    List<Map<String, Objects>> getOnPosition();

//    @Query("SELECT DISTINCT IFNULL(NULLIF(p.position, ''), '신입') AS 포지션 FROM player p ")
//    List<?> getOnPositionNotNull();
//
//    @Query("SELECT p.teamId.teamId , p.position , p.name FROM player p where p.position = 'GK' AND p.teamId.teamId = 'k02'")
//    List<?> getOnPositionAndTeamId();
//
//    @Query("SELECT p.teamId.teamId as 플 , t.teamId as 팀 , t.regionName  FROM player p JOIN Team t on t.teamId = p.teamId.teamId\n" +
//            "                          where p.position = 'GK' AND t.regionName = '수원'")
//    List<?> getOnPositionAndTeamId7();
//
//    @Query("SELECT p.playerName AS 이름,\n" +
//            "       IFNULL(NULLIF(p.height, ''), '0') AS 키,\n" +
//            "       IFNULL(NULLIF(p.weight, ''), '0') AS 몸무게 FROM player p WHERE p.teamId.teamId =\n" +
//            "                                                              (SELECT t.teamId FROM Team t WHERE t.regionName = '서울')")
//    List<?> getOnHeightAndWeight();
//
//    @Query("")
//    List<?> getOnPositionAndTeamId10();
//
//    @Query("")
//    Long getOnCount();
//
//    @Query("")
//    List<?> getOnPositionAndTeamId20();
//
//    @Query("")
//    List<?> getOnPositionAndTeamId21();
}
