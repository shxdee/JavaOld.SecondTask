package com.shxdee.secondtask;

import java.util.GregorianCalendar;
import java.util.Objects;

import static java.lang.StrictMath.ceil;

public class Payment {

    private final GregorianCalendar date;
    private String name;
    private int sum;

    public Payment(String name, int sum, GregorianCalendar date) {
        this.date = date;
        setName(name);
        setSum(sum);
    }

    public Payment(Payment payment) {
        this.date = payment.getDate();
        this.setName(payment.getName());
        this.setSum(payment.getSum());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name must be not null!");
        this.name = name;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getYear() {
        return date.get(GregorianCalendar.YEAR);
    }
    public int getMonth() {
        return 1 + date.get(GregorianCalendar.MONTH);
    }
    public int getDay() {
        return date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        if (sum <= 0) throw new IllegalArgumentException("Negative sum!");
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment p = (Payment) o;
        return getYear() == p.getYear() &&
                getMonth() == p.getMonth() &&
                getDay() == p.getDay()
                && sum == p.getSum() && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, sum);
    }

    @Override
    public String toString() {
        int rub = sum / 100;
        int kop = sum % 100;
        return String.format("Плательщик: %s, Дата: %02d.%02d.%04d, Сумма: %d руб. %d коп.\n", name, getDay(),getMonth(),getYear(), rub, kop);
    }
}