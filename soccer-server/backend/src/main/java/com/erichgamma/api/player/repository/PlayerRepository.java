package com.erichgamma.api.player.repository;

import com.erichgamma.api.player.model.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.player.model.Player;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

    @Query("SELECT DISTINCT position FROM player")
    List<?> getOnPosition();


    @Query("SELECT DISTINCT IFNULL(NULLIF(position, ''), '신입') AS 포지션 FROM player")
    List<?> getOnPositionNotNull();

//@Query("SELECT p FROM player p where p.position = 'GK' AND p.teamId.teamId = 'k02'") //성공


    @Query("SELECT p FROM player p JOIN Team t on t.teamId = p.teamId.teamId\n" +
            "where player.position= 'GK' AND Team .regionName= '수원'")
    List<?> getOnPositionAndTeamId();

    @Query("SELECT p FROM player p WHERE p.position = 'GK'\n" +
            "AND p.teamId.teamId =\n" +
            "(SELECT t.teamId FROM Team t WHERE t.regionName = '수원')")
    List<?> getOnPositionAndTeamId7();



    @Query("SELECT p.playerName AS 이름,\n" +
            "IFNULL(NULLIF(p.height, ''), '0') AS 키,\n" +
            "IFNULL(NULLIF(p.weight, ''), '0') AS 몸무게 FROM player p WHERE p.teamId.teamId =\n" +
            "(SELECT t.teamId FROM Team t WHERE t.regionName = '서울')\n")
    List<?> getOnHeightAndWeight();

    @Query("SELECT p FROM player p WHERE p.position = 'GK'\n" +
            "AND p.teamId.teamId IN ('K02', 'K10')\n" +
            "ORDER BY\n" +
            "    (SELECT t.teamName\n" +
            "     FROM Team t \n" +
            "     WHERE t.teamId = p.teamId.teamId),\n" +
            "    p.playerName")
    List<?> getOnPositionAndTeamId10();

    @Query("SELECT p FROM player p LIMIT 5")
    Long getOnCount();

    @Query("SELECT (SELECT t.teamName\n" +
            "        FROM Team t\n" +
            "        WHERE t.teamId = p.teamId.teamId) AS 소속팀,\n" +
            "    p.playerName AS 선수명,\n" +
            "    p.backNo AS 등번호\n" +
            "FROM player p\n" +
            "WHERE p.position = 'MF'")
    List<?> getOnPositionAndTeamId20();

    @Query("SELECT (SELECT t.teamName\n" +
            "        FROM Team t\n" +
            "        WHERE t.teamId = p.teamId.teamId),\n" +
            "    p.playerName,\n" +
            "    p.backNo\n" +
            "FROM player p\n" +
            "ORDER BY p.height\n" +
            "LIMIT 5")
    List<?> getOnPositionAndTeamId21();
//    @Query("SELECT p FROM player p\n" +
//            "WHERE p.height < (SELECT ROUND(AVG(tp.height), 2)\n" +
//            "                  FROM player tp\n" +
//            "                  WHERE p.teamId.teamId = tp.teamId.teamId);")
    List<?> getOnPositionAndTeamId23();
}
