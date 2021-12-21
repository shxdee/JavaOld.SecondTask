package com.shxdee.secondtask;

public class IncomeDeclaration {
    private final int year;
    private String fullName = null;

    private double[] valueInMonth   = new double[12];
    private double[] valueUpToMonth = new double[12];
    private double[] taxes          = new double[12];

    public IncomeDeclaration(IncomeStatement[] iStatement, int year, String fullName) {
        this.year = year;
        this.fullName = new String(fullName);

        double[] value;
        for (IncomeStatement is : iStatement) {
            value = is.getValue();
            for (int i = 0; i < 12; i++) {
                valueInMonth[i] += value[i];
            }
        }
        double v1 = 0, v2 = 0;
        int taxesProc = 0;      // отметка в 0, 24к и 240к

        for (int i = 0; i < 12; i++) {
            v2 += valueInMonth[i];
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

    public double[] getValuesInMonth() {
        return valueInMonth;
    }

    public double[] getValuesUpToMonth() {
        return valueUpToMonth;
    }

    public double[] getTaxes() {
        return taxes;
    }

    public int getYear() {
        return year;
    }

    public String getFullName() {
        return fullName;
    }
}
