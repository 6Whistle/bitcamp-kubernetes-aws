package com.erichgamma.api.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.schedule.model.Schedule;

import java.util.List;
import java.util.Map;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


//    @Query("SELECT distinct new map (s.stadiumId as stadiumId, s.scheDate as scheDate, " +
//            "s.awayScore as awayScore, s.homeScore as homeScore, s.awayteamId as awayteamId," +
//            "s.hometeamId as hometeamId, s.gubun as gubun ) FROM schedule s WHERE s.stadiumid = :stadiumId")


     @Query("SELECT s.stadiumId.stadiumName FROM schedule s WHERE s.scheDate BETWEEN :startDate AND :endDate")
     List<String> findStadiumNamesByDateRange(String startDate, String endDate);


}

////-- 문제 23
////-- 2012년 5월 한달간 경기가 있는 경기장  조회
//SELECT DISTINCT (SELECT s.stadium_name
//        FROM stadium s
//        WHERE s.stadium_id = sch.stadium_id) '경기장'
//FROM schedule sch
//WHERE YEAR(sch.sche_date) = 2012
//    AND MONTH(sch.sche_date) = 5