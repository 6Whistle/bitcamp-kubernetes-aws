package com.erichgamma.api.team.service;

import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.team.model.Team;
import com.erichgamma.api.team.model.TeamDto;

public interface TeamService extends CommandService<TeamDto>, QueryService<TeamDto> {
    default TeamDto EntityToDto(Team entity){
        return TeamDto.builder()
        .id(entity.getId())
        .teamId(entity.getTeamId())
        .regionName(entity.getRegionName())
        .teamName(entity.getTeamName())
        .origYyyy(entity.getOrigYyyy())
        .stadiumId(entity.getStadiumId())
        .zipCode1(entity.getZipCode1())
        .zipCode2(entity.getZipCode2())
        .address(entity.getAddress())
        .ddd(entity.getDdd())
        .tel(entity.getTel())
        .fax(entity.getFax())
        .homepage(entity.getHomepage())
        .owner(entity.getOwner())
        .build();
    }
}
