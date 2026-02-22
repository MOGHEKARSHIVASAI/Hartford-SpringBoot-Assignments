package org.hartford.springbootproject1.model;

public class Business {
    private int id;
    private String businessName;
    private String industry;
    private String location;
    private int employeeCount;
    private double revenue;

    public Business() {
    }

    public Business(int id, String businessName, String industry, String location, int employeeCount, double revenue) {
        this.id = id;
        this.businessName = businessName;
        this.industry = industry;
        this.location = location;
        this.employeeCount = employeeCount;
        this.revenue = revenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

