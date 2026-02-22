package org.hartford.springbootproject1.service;

import org.hartford.springbootproject1.dao.BusinessDao;
import org.hartford.springbootproject1.model.Business;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessDao dao;

    public BusinessServiceImpl(BusinessDao dao) {
        this.dao = dao;
    }

    @Override
    public Business save(Business business) {
        return dao.save(business);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Business> findAll() {
        return dao.findAll();
    }

    @Override
    public Business findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Business update(int id, Business business) {
        return dao.update(id, business);
    }

    @Override
    public List<Business> findByIndustry(String industry) {
        return dao.findByIndustry(industry);
    }

    @Override
    public List<Business> sortByRevenue() {
        return dao.sortByRevenue();
    }

    @Override
    public List<Business> findByLocation(String location) {
        return dao.findByLocation(location);
    }
}

