package com.erichgamma.api.stadium.repository;

import com.erichgamma.api.stadium.model.StadiumWithTeamDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.stadium.model.Stadium;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    @Query("select distinct new map(s.stadiumName as 홈구장, concat(t.regionName, '[ ]',t.teamName) as 팀명) " +
            "from stadium s join team t on s.stadiumId = t.stadiumId.stadiumId " +
            "where t.regionName = '수원' and s.stadiumName like '수원%'")
    List<Map<String, Object>> stadiumNameWithTeam();

    @Query("select distinct new map(t.teamName as 팀이름, s.stadiumName as 스타디움, " +
            "(select distinct t2.teamName from team t2 where sc.awayteamId = t2.teamId) as 어웨이팀) " +
            "from stadium s " +
            "join team t on s.stadiumId = t.stadiumId.stadiumId " +
            "join schedule sc on s.stadiumId = sc.stadiumId.stadiumId " +
            "where sc.scheDate = '20120317'")
    List<Map<String, Object>> stadiumAndTeamAndSchedule();


    @Query("SELECT distinct new map(p.playerName as 이름, p.position as 포지션, concat(t.teamName, ' ', t.regionName) as 팀명, " +
            "s.stadiumName as 스타디움, sch.scheDate as 경기날짜)" +
            "FROM stadium s " +
            "JOIN schedule sch ON s.stadiumId = sch.stadiumId.stadiumId " +
            "JOIN team t ON s.stadiumId = t.stadiumId.stadiumId " +
            "JOIN player p ON t.teamId = p.teamId.teamId " +
            "WHERE p.position = 'GK' AND t.teamName = '스틸러스' AND sch.scheDate = '20120317'")
    List<Map<String, Object>> pohangSteelersGk();


    @Query("SELECT new map(s.stadiumName as 스타디움, sch.scheDate as 경기일정, home.teamName as 홈팀명, away.teamName as 어웨이팀명) " +
            "FROM stadium s " +
            "JOIN schedule sch on s.stadiumId = sch.stadiumId.stadiumId " +
            "join team home ON home.teamId = sch.hometeamId " +
            "JOIN team away ON away.teamId = sch.awayteamId " +
            "WHERE (sch.homeScore - sch.awayScore) >= 3")
    List<Map<String, Object>> homeTeamWin();

    @Query("SELECT distinct new map(s.stadiumName as 스타디움, " +
            "(SELECT distinct t2.teamName FROM team t2 WHERE t2.stadiumId.stadiumId = s.stadiumId) as 팀명) " +
            "FROM stadium s " +
            "left join team t on s.stadiumId = t.stadiumId.stadiumId")
    List<Map<String, Object>> noHomeTeam();
}
