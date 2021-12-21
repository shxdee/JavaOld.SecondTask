package com.shxdee.secondtask;

public class IncomeStatement {
    private String fullName = null;
    private String organisationName = null;
    private final int year;
    private final double[] value = new double[12];

    public IncomeStatement(double[] value, String fullName, String organisationName, int year) {
        System.arraycopy(value, 0, this.value, 0, 12);
        this.year = year;
        this.fullName = new String(fullName);
        this.organisationName = new String(organisationName);
    }

    public double[] getValue() {
        return value;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYear() {
        return year;
    }
}
