package com.erichgamma.api.team.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erichgamma.api.common.component.MessengerVo;
import com.erichgamma.api.team.model.TeamDto;
import com.erichgamma.api.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public MessengerVo save(TeamDto t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public MessengerVo modify(TeamDto t) {
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
    public List<TeamDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<TeamDto> findById(Long id) {
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
    public List<?> getTeams() {
        return teamRepository.getTeamOrderByTeamName();
    }

    @Override
    public List<?> getNotSelectedPostion() {
        return teamRepository.getNotSelectedPostion();
    }

    @Override
    public List<?> getSuwonDeojeonByHeight() {
        return teamRepository.getSuwonDeojeonByHeight().stream()
        .filter(i -> Integer.parseInt(i.getHeight()) >= 180 && Integer.parseInt(i.getHeight()) <= 180)
        .toList();
    }

    @Override
    public List<?> getIncheonByHeight() {
        return teamRepository.getIncheonByHeight().stream()
        .filter(i -> (Double)(i.get("평균")) < 176.59)
        .toList();
    }
}
