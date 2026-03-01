package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Team;
import org.hartford.mappingdemo.repository.PlayerRepository;
import org.hartford.mappingdemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repo;

    public Team findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }
    public List<Team> findAll() {
        return repo.findAll();
    }
    public Team addTeam(Team team) {
        return repo.save(team);
    }
    public List<String> getPlayerNamesByTeamId(Long id){
        Team t=repo.findById(id).orElseThrow(()->new RuntimeException("invalid team id"));
        return t.getPlayers().stream().map(p->p.getFname()).toList();
    }



}
