package org.hartford.springbootproject1.dao;

import org.hartford.springbootproject1.model.Business;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BusinessDaoImpl implements BusinessDao {
    List<Business> businesses = new ArrayList<>();

    @Override
    public Business save(Business business) {
        businesses.add(business);
        return business;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<Business> it = businesses.iterator();
        while (it.hasNext()) {
            Business b = it.next();
            if (b.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Business> findAll() {
        return businesses;
    }

    @Override
    public Business findById(int id) {
        for (Business b : businesses) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Business update(int id, Business business) {
        for (Business b : businesses) {
            if (b.getId() == id) {
                b.setBusinessName(business.getBusinessName());
                b.setIndustry(business.getIndustry());
                b.setLocation(business.getLocation());
                b.setEmployeeCount(business.getEmployeeCount());
                b.setRevenue(business.getRevenue());
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Business> findByIndustry(String industry) {
        List<Business> res = new ArrayList<>();
        for (Business b : businesses) {
            if (b.getIndustry().equalsIgnoreCase(industry)) {
                res.add(b);
            }
        }
        return res;
    }

    @Override
    public List<Business> sortByRevenue() {
        List<Business> res = new ArrayList<>(businesses);
        res.sort((b1, b2) -> Double.compare(b2.getRevenue(), b1.getRevenue()));
        return res;
    }

    @Override
    public List<Business> findByLocation(String location) {
        List<Business> res = new ArrayList<>();
        for (Business b : businesses) {
            if (b.getLocation().equalsIgnoreCase(location)) {
                res.add(b);
            }
        }
        return res;
    }
}

