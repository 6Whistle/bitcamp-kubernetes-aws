package com.erichgamma.api.schedule.Service;

import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.schedule.model.Schedule;
import com.erichgamma.api.schedule.model.ScheduleDto;


import java.util.List;

public interface ScheduleService extends CommandService<ScheduleDto>, QueryService<ScheduleDto> {
    List<String> findStadiumNamesByDateRange(String startDate, String endDate);

    default Schedule dtoToEntity(ScheduleDto dto) {
        return Schedule.builder()
                .id(dto.getId())
                .hometeamId(dto.getHometeamId())
                .awayteamId(dto.getAwayteamId())
                .gubun(dto.getGubun())
                .awayScore(dto.getAwayScore())
                .homeScore(dto.getHomeScore())
                .scheDate(dto.getScheDate())
                .build();
    }
    default ScheduleDto entityToDto(Schedule schedule) {
        return ScheduleDto.builder()
                .id(schedule.getId())
                .hometeamId(schedule.getHometeamId())
                .awayteamId(schedule.getAwayteamId())
                .homeScore(schedule.getHomeScore())
                .gubun(schedule.getGubun())
                .awayScore(schedule.getAwayScore())
                .scheDate(schedule.getScheDate())
                .build();
    }

}
