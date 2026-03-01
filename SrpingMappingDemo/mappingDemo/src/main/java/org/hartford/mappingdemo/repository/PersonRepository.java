package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
