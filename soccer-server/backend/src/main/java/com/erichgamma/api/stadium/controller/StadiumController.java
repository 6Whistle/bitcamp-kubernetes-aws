package com.erichgamma.api.stadium.controller;

import com.erichgamma.api.common.component.pagination.PageRequestVo;
import com.erichgamma.api.stadium.model.Stadium;
import com.erichgamma.api.stadium.model.StadiumDto;
import com.erichgamma.api.stadium.service.StadiumService;
import com.erichgamma.api.stadium.service.StadiumServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})

@Log4j2
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class StadiumController {
    private final StadiumService stadiumService;

    //-- 문제 11. 팀과 연고지를 연결해서 출력하시오
    // -- [팀 명]                 [홈구장]
    //-- 수원[ ]삼성블루윙즈      수원월드컵경기장
    @GetMapping("/11")
    public List<?> stadiumNameWithTeam() {
        return stadiumService.stadiumNameWithTeam();
    }

    //-- 문제 14 팀, 스타디움, 스케줄을 조인하여 2012-03-17에 열린 각 경기의 팀이름, 스타디움, 어웨이팀 이름 출력
    @GetMapping("/14")
    public List<?> stadiumAndTeamAndSchedule() {
        return stadiumService.stadiumAndTeamAndSchedule();
    }

    //-- 문제 15 2012년 3월 17일 경기에 포항 스틸러스 소속 골키퍼(GK) 선수, 포지션,팀명 (연고지포함), 스타디움, 경기날짜를 구하시오
    //-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
    @GetMapping("/15")
    public List<?> pohangSteelersGk() {
        return stadiumService.pohangSteelersGk();
    }

    //-- 문제 16 홈팀이 3점이상 차이로 승리한 경기의 경기장 이름, 경기 일정 홈팀 이름과 원정팀 이름을 구하시오
    @GetMapping("/16")
    public List<?> homeTeamWin() {
        return stadiumService.homeTeamWin();
    }

    //-- 문제 17 STADIUM 에 등록된 운동장 중에서 홈팀이 없는 경기장까지 전부 나오도록 카운트 값은 19 (힌트 : LEFT JOIN 사용해야함)
    @GetMapping("/17")
    public List<?> noHomeTeam() {
        return stadiumService.noHomeTeam();
    }

}
