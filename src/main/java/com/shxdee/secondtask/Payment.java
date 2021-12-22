package com.shxdee.secondtask;

import java.util.GregorianCalendar;
import java.util.Objects;

import static java.lang.StrictMath.ceil;

public class Payment {

    private final GregorianCalendar date;
    private String name;
    private double sum;

    public Payment(String name, double sum, GregorianCalendar date) {
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        if (sum <= 0) throw new IllegalArgumentException("Negative sum!");
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return date == ((Payment) o).date
                && Double.compare(payment.sum, sum) == 0 && Objects.equals(name, payment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, sum);
    }

    @Override
    public String toString() {
        return String.format("Плательщик: %s, Дата: %02d.%02d.%04d, Сумма: %f руб. %f коп.\n", name, getDay(),getMonth(),getYear(), ceil(sum), sum - ceil(sum));
    }
}