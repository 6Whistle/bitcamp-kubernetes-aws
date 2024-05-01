package com.erichgamma.api.player.repository;

import com.erichgamma.api.player.model.PlayerDto;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT DISTINCT new map (IFNULL(NULLIF(p.position, ''), '신입') AS 포지션) FROM player p ")
    List<Map<String, Objects>> getOnPositionNotNull();

    @Query("SELECT new map (p.teamId.teamId AS teamId , p.position AS POSITION ) FROM player p where p.position = 'GK' AND p.teamId.teamId = 'k02'")
    List<Map<String ,Objects>> getOnPositionAndTeamId();

    @Query("SELECT new map (p.teamId.teamId as 플레이어팀ID , t.teamId as team팀 , t.regionName AS 연고지, p.position AS POSITION) FROM player p JOIN team t on t.teamId = p.teamId.teamId\n" +
            "                          where p.position = 'GK' AND t.regionName = '수원'")
    List<Map<String ,Objects>> getOnPositionAndTeamId7();

    @Query("SELECT new map (p.playerName AS 이름,\n" +
            "       IFNULL(NULLIF(p.height, ''), '0') AS 키,\n" +
            "       IFNULL(NULLIF(p.weight, ''), '0') AS 몸무게) FROM player p WHERE p.teamId.teamId =\n" +
            "                                                              (SELECT t.teamId FROM team t WHERE t.regionName = '서울')")
    List<Map<String ,Objects>> getOnHeightAndWeight();

    @Query("SELECT new map (p.position AS POSITION , p.teamId.teamId AS TEAMID, p.playerName AS PLAYERNAME )FROM player p\n" +
            "WHERE p.position = 'GK'\n" +
            "AND p.teamId.teamId IN ('K02', 'K10')\n" +
            "ORDER BY\n" +
            "    (SELECT t.teamName\n" +
            "     FROM team t\n" +
            "     WHERE t.teamId = p.teamId.teamId),\n" +
            "    p.playerName")
    List<Map<String , Objects>> getOnPositionAndTeamId10();

    @Query("SELECT new map (p.teamId.teamId , p.playerName , p.position , p.name , p.backNo , p.nickname , p.solar , p.ePlayerName) FROM player p ")
    List<Map<String , Objects>> getOnCountAll(Pageable pageable);

    @Query("SELECT new MAP ((SELECT t.teamName\n" +
            "        FROM team t\n" +
            "        WHERE t.teamId = p.teamId.teamId) AS 소속팀,\n" +
            "    p.playerName AS 선수명,\n" +
            "    p.backNo AS 등번호\n" +
            ")FROM player p\n" +
            "WHERE p.position = 'MF'")
    List<Map<String , Objects>> getOnPositionAndTeamId20();

    @Query("SELECT new MAP ((SELECT t.teamName\n" +
            "        FROM team t\n" +
            "        WHERE t.teamId = p.teamId.teamId),\n" +
            "    p.playerName,\n" +
            "    p.backNo\n" +
            ")FROM player p\n" +
            "ORDER BY p.height\n" )
    List<Map<String , Objects>> getOnPositionAndTeamId21(Pageable pageable);
}
