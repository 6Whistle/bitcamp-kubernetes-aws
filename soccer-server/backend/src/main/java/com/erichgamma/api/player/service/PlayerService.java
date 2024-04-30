package com.erichgamma.api.player.service;


import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;
import com.erichgamma.api.player.model.PlayerDto;

import java.util.List;

public interface PlayerService extends CommandService<PlayerDto>, QueryService<PlayerDto> {
    List<?> getOnPosition();

    List<PlayerDto> getOnPositionNotNull();

    List<PlayerDto> getOnPositionAndTeamId();

    List<PlayerDto> getOnPositionAndTeamId7();

    List<PlayerDto> getOnHeightAndWeight();

    List<PlayerDto> getOnPositionAndTeamId10();

    Long getOnCount();

    List<PlayerDto> getOnPositionAndTeamId20();

    List<PlayerDto> getOnPositionAndTeamId21();


//    default Player dtoToEntity(PlayerDto dto){
//        return Player.builder()
//                .id(dto.getId())
//                .ePlayerName(dto.getEPlayerName())
//                .backNo(dto.getBackNo())
//                .birthDate(dto.getBirthDate())
//                .height(dto.getHeight())
//                .joinYyyy(dto.getJoinYyyy())
//                .nation(dto.getNation())
//                .solar(dto.getSolar())
//                .name(dto.getName())
//                .playerId(dto.getPlayerId())
//                .nickname(dto.getNickname())
//                .position(dto.getPosition())
//                .weight(dto.getWeight())
//                .playerName(dto.getPlayerName())
//                .build();
//    }
//    default PlayerDto entityToDto(Player player){
//        return PlayerDto.builder()
//                .playerId(player.getPlayerId())
//                .playerName(player.getPlayerName())
//                .joinYyyy(player.getJoinYyyy())
//                .nation(player.getNation())
//                .backNo(player.getBackNo())
//                .nickname(player.getNickname())
//                .position(player.getPosition())
//                .weight(player.getWeight())
//                .birthDate(player.getBirthDate())
//                .ePlayerName(player.getEPlayerName())
//                .solar(player.getSolar())
//                .id(player.getId())
//                .height(player.getHeight())
//                .name(player.getName())
//                .build();
//    }



}
