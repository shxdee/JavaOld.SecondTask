package com.shxdee.secondtask;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringProcessorTest {

    @Test
    public void testCopyStringNTime() {
        String s = StringProcessor.CopyStringNTime("123",3);
        assertEquals(s, "123123123");
    }

    @Test
    public void testCountIncludeStringToString() {
        int count = StringProcessor.CountIncludeStringToString("123456789123451231", "12");
        assertEquals(count, 3);
    }

    @Test
    public void testParseStringOneTwoThree() {
        String s = StringProcessor.ParseStringOneTwoThree("1 2 3 1 2 3");
        assertEquals(s,"один два три один два три");
    }

    @Test
    public void testDeleteEverySecondInStringBuilder() {
        StringBuilder s = new StringBuilder("1234567890123");
        StringProcessor.DeleteEverySecondInStringBuilder(s);
        assertEquals(s.toString(), "1357913");
    }

    @Test
    public void testReverseWords() {
        String s = StringProcessor.ReverseWords("aaa bbb cc dd ");
        assertEquals(s," dd cc bbb aaa");
        s = StringProcessor.ReverseWords("  ");
        assertEquals(s,"  ");
        s = StringProcessor.ReverseWords("a  ");
        assertEquals(s,"  a");
        s = StringProcessor.ReverseWords(" aa aa  ");
        assertEquals(s,"  aa aa ");
    }

    @Test
    public void testConvertHEXtoDECinString() {
        String s = StringProcessor.ConvertHEXtoDECinString("Васе 0x00000010 лет");
        assertEquals(s,"Васе 16 лет");

        s = StringProcessor.ConvertHEXtoDECinString("Васе 0xA лет");
        assertEquals(s,"Васе 10 лет");
    }
}