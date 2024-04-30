package com.erichgamma.api.player.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.erichgamma.api.player.model.Player;
import org.springframework.stereotype.Service;

import com.erichgamma.api.common.component.MessengerVo;
import com.erichgamma.api.player.model.PlayerDto;
import com.erichgamma.api.player.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;

    @Override
    public MessengerVo save(PlayerDto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public MessengerVo modify(PlayerDto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public MessengerVo insertMany() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMany'");
    }

    @Override
    public MessengerVo deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public MessengerVo deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public List<PlayerDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<PlayerDto> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }



    @Override
    public List<PlayerDto> getOnPosition() {
        return (List<PlayerDto>) playerRepository.getOnPosition();

    }

    @Override
    public List<PlayerDto> getOnPositionNotNull() {
        return (List<PlayerDto>) playerRepository.getOnPositionNotNull();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId7() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId7();
    }

    @Override
    public List<PlayerDto> getOnHeightAndWeight() {
        return (List<PlayerDto>) playerRepository.getOnHeightAndWeight();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId10() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId10();
    }

    @Override
    public Long getOnCount() {
        return playerRepository.getOnCount();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId20() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId20();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId21() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId21();
    }

    @Override
    public List<PlayerDto> getOnPositionAndTeamId23() {
        return (List<PlayerDto>) playerRepository.getOnPositionAndTeamId23();
    }


}
