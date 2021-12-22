package com.shxdee.secondtask;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

public class FinanceReport {
    private final Payment[] arr;
    private final String name;
    private final GregorianCalendar date;

    public FinanceReport(String name, GregorianCalendar date, Payment... arr) {
        this.date = date;
        this.name = name;
        this.arr = arr.clone();
    }

    public FinanceReport(FinanceReport financeReport) {
        this.date = financeReport.getDate();
        this.name = financeReport.getName();
        this.arr = financeReport.getArr().clone();
    }

    public String getName() {
        return name;
    }

    public Payment[] getArr() {
        return arr;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getYear() {
        return date.get(GregorianCalendar.YEAR);
    }
    public int getMonth() { return 1 + date.get(GregorianCalendar.MONTH); }
    public int getDay() {
        return date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    private void checkIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (this.arr == null || this.arr.length <= index) throw new IndexOutOfBoundsException();
    }

    public int getCount() {
        return arr.length;
    }

    public Payment getPayment(int index) {
        checkIndex(index);
        return arr[index];
    }

    public void setPayment(int index, Payment payment) {
        checkIndex(index);
        arr[index] = new Payment(payment);
    }

    @Override
    public String toString() {
        String result = String.format("Автор: %s, Дата: %02d.%02d.%04d, Платежи:\n", name, getDay(),getMonth(),getYear());
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    result = result + arr[i].toString();
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return date == that.date && Arrays.equals(arr, that.arr) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, Arrays.hashCode(arr));
    }
}