package com.erichgamma.api.schedule.controller;

import com.erichgamma.api.schedule.Service.ScheduleService;
import com.erichgamma.api.schedule.model.Schedule;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequiredArgsConstructor
@RequestMapping(path = "/api")
@Slf4j
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/list")
    public ResponseEntity<List<String>> getStadiumNamesByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List<String> stadiumNames = scheduleService.findStadiumNamesByDateRange(startDate, endDate);
        return ResponseEntity.ok(stadiumNames);
    }
}


