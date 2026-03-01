package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Player;
import org.hartford.mappingdemo.entity.Team;
import org.hartford.mappingdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService service;
    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return service.addPlayer(player);
    }
    @GetMapping
    public List<Player> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/team/{id}")
    public Team getTeamByPlayerId(@PathVariable Long id){
        return service.getTeamByPlayerId(id);
    }

}
