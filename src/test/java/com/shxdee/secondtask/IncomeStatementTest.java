package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertArrayEquals;
import java.util.Arrays;


public class IncomeStatementTest {

    double[] arr = {2900, 3600, 3600, 4000, 4200, 3900, 4300, 6000, 4700, 4600, 4500, 4800};
    IncomeStatement TestIncomeStatement = new IncomeStatement(arr, "Проскурин Евгений Юрьевич", "ОмГУ", 2021);

    @Test
    public void testGetIncome() {
        assertEquals(TestIncomeStatement.getIncome(), arr);
    }

    public void testGetOrganisationName() {
        assertEquals(TestIncomeStatement.getOrganisationName(), "ОмГУ");
    }

    public void testGetName() {
        assertEquals(TestIncomeStatement.getName(), "Проскурин Евгений Юрьевич");
    }

    public void testGetYear() {
        assertEquals(TestIncomeStatement.getYear(), 2021);
    }
}