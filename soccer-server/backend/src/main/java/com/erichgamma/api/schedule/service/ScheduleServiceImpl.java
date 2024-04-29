package com.erichgamma.api.schedule.service;


import com.erichgamma.api.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl extends ScheduleService {

    private final ScheduleRepository scheduleRepository;
}
