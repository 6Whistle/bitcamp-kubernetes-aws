package com.erichgamma.api.stadium.service;

import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.stadium.model.StadiumDto;

public interface StadiumService extends CommandService<StadiumDto>, QueryService<StadiumDto> {
}
