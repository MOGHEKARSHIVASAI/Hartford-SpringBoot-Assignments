package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
