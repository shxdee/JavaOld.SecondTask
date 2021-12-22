package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FinanceReportTest {

    FinanceReport TestFinanceReport = new FinanceReport("Проскурин Евгений Юрьевич", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)),
            new Payment("Заплативший Три Сергеевич", 320, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));

    @Test
    public void testFinanceReportEquals() {
        FinanceReport TestFinanceReport2 = new FinanceReport(TestFinanceReport);
        assertEquals(TestFinanceReport2, TestFinanceReport);
    }

    @Test
    public void testFinanceReportToString() {
        String TestString = "Автор: Проскурин Евгений Юрьевич, Дата: 24.11.2021, Платежи:\n" +
                "Плательщик: Плательщиков Один Василевич, Дата: 12.03.2010, Сумма: 110,000000 руб. 0,000000 коп.\n" +
                "Плательщик: Плачущий Два Игоревич, Дата: 18.07.2015, Сумма: 250,000000 руб. 0,000000 коп.\n" +
                "Плательщик: Заплативший Три Сергеевич, Дата: 22.10.2020, Сумма: 320,000000 руб. 0,000000 коп.\n";
        assertEquals(TestFinanceReport.toString(), TestString);
    }

    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(TestFinanceReport);
        copy.setPayment(0, new Payment("Неизвестный Безимени Безотчества", 40, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));
        assertNotEquals(copy.getPayment(0), TestFinanceReport.getPayment(0));
    }
}