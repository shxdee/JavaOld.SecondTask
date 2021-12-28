package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class FinanceReportProcessorTest {

    FinanceReport TestFinanceReport = new FinanceReport("Проскурин Евгений Юрьевич", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)),
            new Payment("Заплативший Три Сергеевич", 320, new GregorianCalendar(2020, Calendar.OCTOBER, 22)));

    FinanceReport TestFinanceReport2 = new FinanceReport("Проскурин Евгений Юрьевич", new GregorianCalendar(2021, Calendar.NOVEMBER, 24),
            new Payment("Плательщиков Один Василевич", 110, new GregorianCalendar(2010, Calendar.MARCH, 12)),
            new Payment("Плачущий Два Игоревич", 250, new GregorianCalendar(2015, Calendar.JULY, 18)));

    @Test
    public void testFinanceReportProcessorByChar() {
        FinanceReport FinanceReportByChar = new FinanceReport(TestFinanceReport);
        assertEquals(FinanceReportProcessor.GetPaymentByFirstSymbol(FinanceReportByChar, 'П'),TestFinanceReport2);
    }

    @Test
    public void testFinanceReportProcessorByValue() {
        assertEquals(FinanceReportProcessor.GetPaymentUnderValue(TestFinanceReport, 300), TestFinanceReport2);
    }

    @Test
    public void testFinanceReportProcessorByDate() {
        assertEquals(FinanceReportProcessor.GetTotalPaymentByDate(TestFinanceReport, new GregorianCalendar(2015, Calendar.JULY, 18)), 250);
    }

    @Test
    public void testFinanceReportProcessorGetMonthWithoutPayment() {
        String str = "Январь Февраль Март Апрель Май Июнь Июль Август Сентябрь Ноябрь Декабрь ";
        assertEquals(str, FinanceReportProcessor.GetMonthWithoutPayment(TestFinanceReport, 2020));
    }

}