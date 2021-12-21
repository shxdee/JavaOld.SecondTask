package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertArrayEquals;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FinanceReportTest {

    FinanceReport TestFinanceReport = new FinanceReport("Проскурин Евгений Юрьевич", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)),
            new Payment("Заплативший Три Сергеевич", 320, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));

    /*@Test
    public void testFinanceReportToString() {
        String TestString = "Автор: Проскурин Евгений Юрьевич, дата: 24.11.2021, Платежи:\n" +
                "Плательщик: Плательщиков Один Василевич, дата : 12.03.2010 сумма : 110,000000 руб. 0,000000 коп.\n" +
                "Плательщик: Плачущий Два Игоревич, дата : 18.07.2015 сумма : 250,000000 руб. 0,000000 коп.\n" +
                "Плательщик: Заплативший Три Сергеевич, дата : 22.10.2020 сумма : 320,000000 руб. 0,000000 коп.\n";
        assertEquals(TestFinanceReport.toString(), TestString);
    }*/



    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(TestFinanceReport);
        copy.setPayment(0, new Payment("Неизвестный Безимени Безотчества", 40, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));
        assertNotEquals(copy.getPayment(0), TestFinanceReport.getPayment(0));
    }
}