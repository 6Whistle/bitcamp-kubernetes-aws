package com.erichgamma.api.team.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.player.model.PlayerDto;
import com.erichgamma.api.team.model.Team;
import com.erichgamma.api.team.model.TeamDto;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    String fromDto = " new com.erichgamma.api.team.model.TeamDto(" + 
                    "t.id, t.teamId, t.regionName, t.teamName, t.eTeamName, t.origYyyy, " + 
                    "t.zipCode1, t.zipCode2, t.address, t.ddd, t.tel, t.fax, " + 
                    "t.homepage, t.owner, t.stadiumId.stadiumId) from team t ";


    @Query(value = "SELECT " + fromDto + "ORDER BY t.teamName ASC")
    List<TeamDto> getTeamsOrderByTeamName();

    @Query(value =  
    "SELECT new map(t.teamName AS teamName, p.playerName AS playerName)" + 
    "FROM team t JOIN player p ON t.teamId = p.teamId.teamId " +
    "WHERE p.position = \'\'" + 
    "ORDER BY t.teamName, p.playerName")
    List<Map<String, Object>> getNotSelectedPostion();

    @Query(value = 
    "SELECT new map(" +
    "p.id AS id, p.playerId AS playerId, p.name AS name, p.teamId.teamId AS teamId, p.playerName AS playerName, " + 
    "p.ePlayerName AS ePlayerName, p.nickname AS nickname, p.joinYyyy AS joinYyyy, p.position AS position, " + 
    "p.backNo AS backNo, p.nation AS nation, p.birthDate AS birthDate, p.solar AS solar, p.height AS height, p.weight AS weight) FROM team t " +
    "JOIN player p ON t.teamId = p.teamId.teamId " +
    "WHERE p.height != \'\' " +
    "ORDER BY p.height, p.playerName")
    List<Map<String, Object>> getTeamsByteamName();

    @Query(value = 
    "SELECT new map(t.teamId AS 팀ID, t.teamName AS 팀명, ROUND(AVG(CAST(p.height AS double)), 2) AS 평균) FROM team t " + 
    "JOIN player p ON t.teamId = p.teamId.teamId " +
    "GROUP BY t.teamId, t.teamName")
    List<Map<String, Object>> getHeightAvgByTeam();
    
}
