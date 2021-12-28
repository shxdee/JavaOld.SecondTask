package com.shxdee.secondtask;

public class IncomeDeclaration {
    private final int year;
    private String name = null;

    private final double[] incomeInMonth   = new double[12];
    private final double[] taxes          = new double[12];

    public IncomeDeclaration(IncomeStatement[] iStatement, int year, String name) {
        this.year = year;
        this.name = name;

        double[] income;
        for (IncomeStatement is : iStatement) {
            income = is.getIncome();
            for (int i = 0; i < 12; i++) {
                incomeInMonth[i] += income[i];
            }
        }
        double v1 = 0, v2 = 0;
        int taxesProc = 0;

        for (int i = 0; i < 12; i++) {
            v2 += incomeInMonth[i];
            if (taxesProc == 0) {
                if (v2 > 240000) {
                    taxes[i] += (v2 - 240000) * 0.2 + (216000 - v1) * 0.13;
                    taxesProc = 2;
                } else if (v2 > 24000) {
                    taxes[i] += (v2 - 24000) * 0.13;
                    taxesProc = 1;
                }
            } else if (taxesProc == 1) {
                if (v2 > 240000) {
                    taxes[i] += (v2 - 240000) * 0.2 + (240000 - v1) * 0.13;
                    taxesProc = 2;
                } else {
                    taxes[i] += (v2 - v1) * 0.13;
                }
            } else {
                taxes[i] += (v2 - v1) * 0.2;
            }
            v1 = v2;
        }
    }

    public double getTaxesForYear() {
        double result = 0;
        for (double item: taxes) {
            result += item;
        }
        return result;
    }

    public double[] getIncomeInMonth() {
        return incomeInMonth;
    }

    public double[] getTaxes() {
        return taxes;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
