package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Arrays;


public class IncomeDeclarationTest {

    double[] arr = {2900, 3600, 3600, 4000, 4200, 3900, 4300, 6000, 4700, 4600, 4500, 4800};
    IncomeStatement[] TestIncomeStatement = {new IncomeStatement(arr, "Проскурин Евгений Юрьевич", "ОмГУ", 2021)};
    IncomeDeclaration TestIncomeDeclaration = new IncomeDeclaration(TestIncomeStatement, 2021, "Проскурин Евгений Юрьевич");
    double[] arrTax = {0,0,0,0,0,0,325,780,611,598,585,624};
    double totalTax = 3523;

    @Test
    public void testDeclarationGetIncomeInMonth() {
        assertEquals(arr, TestIncomeDeclaration.getIncomeInMonth());
    }

    @Test
    public void testDeclarationTaxes() {
        assertEquals(arrTax, TestIncomeDeclaration.getTaxes());
    }

    @Test
    public void testDeclarationAllTaxes() {
        assertEquals(totalTax, TestIncomeDeclaration.getTaxesForYear());
    }
}