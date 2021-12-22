package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class PaymentTest {

    Payment TestPayment = new Payment("Проскурин Евгений Юрьевич", 50, new GregorianCalendar(2021, Calendar.NOVEMBER, 24));

    @Test
    public void testPaymentsGetName() {
        assertEquals(TestPayment.getName(), "Проскурин Евгений Юрьевич");
    }

    @Test
    public void testPaymentsGetSum() {
        assertEquals(TestPayment.getSum(), 50);
    }

    @Test
    public void testPaymentsGetYear() {
        assertEquals(TestPayment.getYear(), 2021);
    }

    @Test
    public void testPaymentsGetMonth() {
        assertEquals(TestPayment.getMonth(), 11);
    }

    @Test
    public void testPaymentsGetDay() {
        assertEquals(TestPayment.getDay(), 24);
    }

    @Test
    public void testPaymentEquals() {
        Payment TestPayment2 = new Payment(TestPayment);
        assertEquals(TestPayment, TestPayment2);
    }

    @Test
    public void testPaymentToString() {
        String TestString = "Плательщик: Проскурин Евгений Юрьевич, Дата: 24.11.2021, Сумма: 50,000000 руб. 0,000000 коп.\n";
        assertEquals(TestPayment.toString(), TestString);
    }
}