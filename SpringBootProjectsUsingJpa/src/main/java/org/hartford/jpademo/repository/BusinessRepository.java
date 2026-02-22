package org.hartford.jpademo.repository;

import org.hartford.jpademo.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findByIndustry(String industry);
    List<Business> findByLocation(String location);
    List<Business> findByRevenueGreaterThan(double revenue);
    List<Business> findByIndustryAndLocation(String industry, String location);
}

