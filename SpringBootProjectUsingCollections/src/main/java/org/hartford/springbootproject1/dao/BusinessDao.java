package org.hartford.springbootproject1.dao;

import org.hartford.springbootproject1.model.Business;

import java.util.List;

public interface BusinessDao {
    Business save(Business business);
    boolean deleteById(int id);
    List<Business> findAll();
    Business findById(int id);
    Business update(int id, Business business);
    List<Business> findByIndustry(String industry);
    List<Business> sortByRevenue();
    List<Business> findByLocation(String location);
}

