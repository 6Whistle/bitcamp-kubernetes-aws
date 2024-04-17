package com.erichgamma.api.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.erichgamma.api.board.model.Board;
import com.erichgamma.api.board.model.BoardDto;
import com.erichgamma.api.board.repository.BoardRepository;
import com.erichgamma.api.common.component.MessengerVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public MessengerVo save(BoardDto boardDto) {
        return MessengerVo.builder()
        .message(
            Stream.of(boardDto)
            .filter(i -> !existsByTitle(i.getTitle()))
            .peek(i -> boardRepository.save(Board.builder().title(i.getTitle()).description(i.getDescription()).build()))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo modify(BoardDto boardDto) {
        return MessengerVo.builder()
        .message(
            boardRepository.findById(boardDto.getId()).stream()
            .peek(i -> i.setTitle(boardDto.getTitle()))
            .peek(i -> i.setDescription(boardDto.getDescription()))
            .map(i -> boardRepository.save(i))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo insertMany() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMany'");
    }

    @Override
    public MessengerVo deleteById(Long id) {
        return MessengerVo.builder()
        .message(
            Stream.of(id)
            .filter(i -> existsById(i))
            .peek(i -> boardRepository.deleteById(i))
            .map(i -> "SUCCESS")
            .findAny()
            .orElseGet(() -> "FAILURE")
        )
        .build();
    }

    @Override
    public MessengerVo deleteAll() {
        boardRepository.deleteAll();
        return MessengerVo.builder().message("SUCCESS").build();
    }

    @Override
    public List<BoardDto> findAll() {
        return boardRepository.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return boardRepository.findById(id).map(i -> entityToDto(i));
    }

    @Override
    public Long count() {
        return boardRepository.count();
    }

    @Override
    public Boolean existsById(Long id) {
        return boardRepository.existsById(id);
    }

    @Override
    public Boolean existsByTitle(String title) {
        return boardRepository.existsByTitle(title);
    }
}
