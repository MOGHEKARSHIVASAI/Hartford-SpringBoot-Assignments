package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Player;
import org.hartford.mappingdemo.entity.Team;
import org.hartford.mappingdemo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repo;

    public List<Player> findAll() {
        return repo.findAll();
    }
    public  Player findById(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("invalid id"));
    }
    public Player addPlayer(Player player){
        return repo.save(player);
    }
    public Team getTeamByPlayerId(Long id){
        Player p=repo.findById(id).orElseThrow(()->new RuntimeException("invalid player id"));
        return p.getTeam();
    }
}
