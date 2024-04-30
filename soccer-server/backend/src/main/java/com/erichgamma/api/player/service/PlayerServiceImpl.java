package com.erichgamma.api.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
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
    public List<?> getOnPosition() {
        return playerRepository.getOnPosition();
    }


    @Override
    public List<?> getOnPositionNotNull() {
        return  playerRepository.getOnPositionNotNull();
    }

    @Override
    public List<?> getOnPositionAndTeamId() {
        return  playerRepository.getOnPositionAndTeamId();
    }

    @Override
    public List<?> getOnPositionAndTeamId7() {
        return  playerRepository.getOnPositionAndTeamId7();
    }

    @Override
    public List<?> getOnHeightAndWeight() {
        return  playerRepository.getOnHeightAndWeight();
    }

    @Override
    public List<?> getOnPositionAndTeamId10() {
        return  playerRepository.getOnPositionAndTeamId10();
    }

    @Override
    public List<?> getOnCountAll( ) {
        int a =5;
        return playerRepository.getOnCountAll(Pageable.ofSize(a));
    }



    @Override
    public List<?> getOnPositionAndTeamId20() {
        return  playerRepository.getOnPositionAndTeamId20();
    }

    @Override
    public List<?> getOnPositionAndTeamId21() {
        int a = 5;
        return  playerRepository.getOnPositionAndTeamId21(Pageable.ofSize(a));
    }
}



