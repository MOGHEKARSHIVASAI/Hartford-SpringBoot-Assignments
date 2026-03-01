package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {

}
