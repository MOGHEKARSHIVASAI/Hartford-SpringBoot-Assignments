package org.hartford.jpademo.service;

import org.hartford.jpademo.entity.Business;
import org.hartford.jpademo.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository repo;

    public Business addBusiness(Business business) {
        return repo.save(business);
    }

    public boolean deleteById(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Business> findAll() {
        return repo.findAll();
    }

    public Business findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Business update(Long id, Business b) {
        Business business = findById(id);
        if (business != null) {
            business.setBusinessName(b.getBusinessName());
            business.setIndustry(b.getIndustry());
            business.setLocation(b.getLocation());
            business.setEmployeeCount(b.getEmployeeCount());
            business.setRevenue(b.getRevenue());
            repo.save(business);
            return business;
        }
        return null;
    }

    public List<Business> findByIndustry(String industry) {
        return repo.findByIndustry(industry);
    }

    public List<Business> findByLocation(String location) {
        return repo.findByLocation(location);
    }

    public List<Business> sortByRevenue() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "revenue"));
    }

    public List<Business> findByRevenueGreaterThan(double revenue) {
        return repo.findByRevenueGreaterThan(revenue);
    }

    public List<Business> findByIndustryAndLocation(String industry, String location) {
        return repo.findByIndustryAndLocation(industry, location);
    }
}

