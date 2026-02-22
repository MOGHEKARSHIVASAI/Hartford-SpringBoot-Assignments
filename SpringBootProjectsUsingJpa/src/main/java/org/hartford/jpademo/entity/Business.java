package org.hartford.jpademo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String industry;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int employeeCount;

    @Column(nullable = false)
    private double revenue;

    public Business() {
    }

    public Business(Long id, String businessName, String industry, String location, int employeeCount, double revenue) {
        this.id = id;
        this.businessName = businessName;
        this.industry = industry;
        this.location = location;
        this.employeeCount = employeeCount;
        this.revenue = revenue;
    }

    public Business(String businessName, String industry, String location, int employeeCount, double revenue) {
        this.businessName = businessName;
        this.industry = industry;
        this.location = location;
        this.employeeCount = employeeCount;
        this.revenue = revenue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", industry='" + industry + '\'' +
                ", location='" + location + '\'' +
                ", employeeCount=" + employeeCount +
                ", revenue=" + revenue +
                '}';
    }
}

