package com.shxdee.secondtask;

public class IncomeStatement {
    private String name = null;
    private String organisationName = null;
    private final int year;
    private final double[] income = new double[12];

    public IncomeStatement(double[] income, String name, String organisationName, int year) {
        System.arraycopy(income, 0, this.income, 0, 12);
        this.year = year;
        this.name = new String(name);
        this.organisationName = new String(organisationName);
    }

    public double[] getIncome() {
        return income;
    }

    public String getOrganisationName() { 
        return organisationName; 
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
