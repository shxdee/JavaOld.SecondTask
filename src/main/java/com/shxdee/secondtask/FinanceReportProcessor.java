package com.shxdee.secondtask;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FinanceReportProcessor {
    public static FinanceReport GetPaymentByFirstSymbol(FinanceReport fr, char c) {
        FinanceReport result = null;
        if (fr != null) {
            int len = fr.getCount();
            boolean[] symbolTrue = new boolean[len];
            int countPayments = 0;
            Payment p = null;
            for (int i = 0; i < len; i++) {
                p = fr.getPayment(i);
                if (p.getName().charAt(0) == c) {
                    symbolTrue[i] = true;
                    countPayments++;
                } else {
                    symbolTrue[i] = false;
                }
            }
            Payment[] payments = new Payment[countPayments];
            for (int i = 0, j = 0; i < len; i++) {
                if (symbolTrue[i]) {
                    payments[j] = new Payment(fr.getPayment(i));
                    j++;
                }
            }
            result = new FinanceReport(fr.getName(), fr.getDate(), payments);
        }
        return result;
    }

    public static FinanceReport GetPaymentUnderValue(FinanceReport fr, double value) {
        FinanceReport result = null;
        if (fr != null) {
            int len = fr.getCount();
            boolean[] symbolTrue = new boolean[len];
            int countPayments = 0;
            Payment p = null;
            for (int i = 0; i < len; i++) {
                p = fr.getPayment(i);
                if (p.getSum() <= value) {
                    symbolTrue[i] = true;
                    countPayments++;
                } else {
                    symbolTrue[i] = false;
                }
            }
            Payment[] payments = new Payment[countPayments];
            for (int i = 0, j = 0; i < len; i++) {
                if (symbolTrue[i]) {
                    payments[j] = new Payment(fr.getPayment(i));
                    j++;
                }
            }
            result = new FinanceReport(fr.getName(), fr.getDate(), payments);
        }
        return result;
    }

    public static double GetTotalPaymentByDate(FinanceReport fr, GregorianCalendar date) {
        double totalPayment = 0;
        if (date != null && fr != null) {
            int len = fr.getCount();
            Payment p = null;
            for (int i = 0; i < len; i++) {
                p = fr.getPayment(i);
                if (date == p.getDate()) {
                    totalPayment += p.getSum();
                }
            }
        }
        return totalPayment;
    }

    public static String GetMonthWithoutPayment(FinanceReport fr, int year) {
        String result = "";
        if (fr != null) {
            int len = fr.getCount();
            boolean[] symbolTrue = new boolean[12];
            Payment p = null;
            for (int i = 0; i < len; i++) {
                p = fr.getPayment(i);
                if (p.getYear() == year) { symbolTrue[p.getMonth()] = true; }
            }
            if (!symbolTrue[0]) { result += "Январь "; }
            if (!symbolTrue[1]) { result += "Февраль "; }
            if (!symbolTrue[2]) { result += "Март "; }
            if (!symbolTrue[3]) { result += "Апрель "; }
            if (!symbolTrue[4]) { result += "Май "; }
            if (!symbolTrue[5]) { result += "Июнь "; }
            if (!symbolTrue[6]) { result += "Июль "; }
            if (!symbolTrue[7]) { result += "Август "; }
            if (!symbolTrue[8]) { result += "Сентябрь "; }
            if (!symbolTrue[9]) { result += "Октябрь "; }
            if (!symbolTrue[10]) { result += "Ноябрь "; }
            if (!symbolTrue[11]) { result += "Декабрь "; }
        }
        return result;
    }
}