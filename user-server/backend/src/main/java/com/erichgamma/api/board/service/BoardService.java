package com.erichgamma.api.board.service;

import com.erichgamma.api.board.model.Board;
import com.erichgamma.api.board.model.BoardDto;
import com.erichgamma.api.common.command.CommandService;
import com.erichgamma.api.common.query.QueryService;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto>{
    default BoardDto entityToDto(Board entity){
        return BoardDto.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .content(entity.getContent())
        .regDate(entity.getRegLocalDateTime().toString())
        .modDate(entity.getModLocalDateTime().toString())
        .build();
    }

    Boolean existsByTitle(String title);
}
