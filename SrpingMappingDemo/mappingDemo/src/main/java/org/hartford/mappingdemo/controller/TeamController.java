package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Team;
import org.hartford.mappingdemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping
    public Team addTeam(@RequestBody Team team){
        return service.addTeam(team);
    }

    @GetMapping()
    public List<Team> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Team findById(Long id) {
        return service.findById(id);
    }
    @GetMapping("/players/{id}")
    public List<String> getPlayerNamesByTeamId(@PathVariable Long id){
        return service.getPlayerNamesByTeamId(id);
    }

}

