package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class IncomeStatementTest {

    double[] arr = {2900, 3600, 3600, 4000, 4200, 3900, 4300, 6000, 4700, 4600, 4500, 4800};
    IncomeStatement TestIncomeStatement = new IncomeStatement(arr, "Проскурин Евгений Юрьевич", "ОмГУ", 2021);

    @Test
    public void testGetIncome() {
        assertEquals(TestIncomeStatement.getIncome(), arr);
    }

    @Test
    public void testGetOrganisationName() {
        assertEquals(TestIncomeStatement.getOrganisationName(), "ОмГУ");
    }

    @Test
    public void testGetName() {
        assertEquals(TestIncomeStatement.getName(), "Проскурин Евгений Юрьевич");
    }

    @Test
    public void testGetYear() {
        assertEquals(TestIncomeStatement.getYear(), 2021);
    }
}