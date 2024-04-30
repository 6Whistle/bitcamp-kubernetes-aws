package com.erichgamma.api.player.controller;

import com.erichgamma.api.player.model.Player;
import com.erichgamma.api.player.model.PlayerDto;
import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erichgamma.api.player.service.PlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ApiResponses(value = {
    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
    @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController  //controller + ResponseBody
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/player/")
@Slf4j
public class PlayerController {
    private final PlayerService playerService;


    @GetMapping("/soccer/2")
    public ResponseEntity<List<?>> getOnPosition() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPosition());

    }

    @GetMapping("/soccer/3")
    public ResponseEntity<List<PlayerDto>> getOnPositionNotNull() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionNotNull());
    }

    @GetMapping("/soccer/4")
    public ResponseEntity<List<PlayerDto>> getOnPositionAndTeamId() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionAndTeamId());
    }

    @GetMapping("/soccer/8")
    public ResponseEntity<List<PlayerDto>> getOnPositionAndTeamId7() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionAndTeamId7());
    }

    @GetMapping("/soccer/9")
    public ResponseEntity<List<PlayerDto>> getOnHeightAndWeight() throws SQLException {
        return ResponseEntity.ok(playerService.getOnHeightAndWeight());
    }

    @GetMapping("/soccer/10")
    public ResponseEntity<List<PlayerDto>> getOnPositionAndTeamId10() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionAndTeamId10());
    }

    @GetMapping("/soccer/18")
    public ResponseEntity<Long> getOnCount() throws SQLException {
        return ResponseEntity.ok(playerService.getOnCount());
    }

    @GetMapping("/soccer/20")
    public ResponseEntity<List<PlayerDto>> getOnPositionAndTeamId20() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionAndTeamId20());
    }
    @GetMapping("/soccer/21")
    public ResponseEntity<List<PlayerDto>> getOnPositionAndTeamId21() throws SQLException {
        return ResponseEntity.ok(playerService.getOnPositionAndTeamId21());
    }





}
