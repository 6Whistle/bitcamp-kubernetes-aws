package com.erichgamma.api.player.service;


import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.player.model.PlayerDto;

public interface PlayerService extends CommandService<PlayerDto>, QueryService<PlayerDto> {
}
