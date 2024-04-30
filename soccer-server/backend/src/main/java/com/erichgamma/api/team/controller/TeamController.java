package com.erichgamma.api.team.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichgamma.api.team.service.TeamService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "Invalid ID supplied")
})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/1")
    public List<?> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/12")
    public List<?> getSuwonDeojeonByHight(){
        return teamService.getSuwonDeojeonByHeight();
    }

    @GetMapping("/13")
    public List<?> getNotSelectedPostion(){
        return teamService.getNotSelectedPostion();
    } 

    @GetMapping("/19")
    public List<?> getIncheonByHeight(){
        return teamService.getIncheonByHeight();
    }
}
