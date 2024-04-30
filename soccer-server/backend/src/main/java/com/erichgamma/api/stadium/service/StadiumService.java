package com.erichgamma.api.stadium.service;

import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.stadium.model.StadiumDto;

import java.util.List;

public interface StadiumService extends CommandService<StadiumDto>, QueryService<StadiumDto> {

    List<?> stadiumNameWithTeam();

    List<?> stadiumAndTeamAndSchedule();

    List<?> pohangSteelersGk();

    List<?> homeTeamWin();

    List<?> noHomeTeam();
}
