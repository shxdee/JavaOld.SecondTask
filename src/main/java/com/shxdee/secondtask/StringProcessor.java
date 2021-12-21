package com.shxdee.secondtask;

public class StringProcessor {

    public static String CopyStringNTime(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Отрицательное количество повторений строки.");
        }
        String str = "";
        for (int i = 0; i < n; i++) {
            str += s;
        }
        return str;
    }


    public static int CountIncludeStringToString(String s1, String s2) {
        int count = 0;
        int index;
        boolean includeTrue;

        if (s2 == null || "".equals(s2)) {
            throw new IllegalArgumentException("Первая строка пустая или имеет значение null.");
        }
        else if (s1 != null) {
            if (s1.length() >= s2.length()) {
                index = s1.indexOf(s2.charAt(0));
                while (index != -1) {
                    includeTrue = true;
                    for (int i = 1; i < s2.length() && includeTrue; i++) {
                        if (index + s2.length() > s1.length()) {
                            includeTrue = false;
                        }
                        else if (s1.charAt(index + i) != s2.charAt(i)) {
                            includeTrue = false;
                        }
                    }
                    if (includeTrue) {
                        count++;
                    }
                    index = s1.indexOf(s2.charAt(0), index + 1);
                }
            }
        }
        return count;
    }


    public static String ParseStringOneTwoThree(String str) {
        if (str == null) throw new IllegalArgumentException("str can't be null");
        if (str.isEmpty()) return "";

        str = str.replaceAll("1", "один");
        str = str.replaceAll("2", "два");
        str = str.replaceAll("3", "три");

        return str;
    }


    public static void DeleteEverySecondInStringBuilder(StringBuilder str) {
        if (str != null) {
            int len = str.length();
            for (int i = 1; i < len; i++) {
                str.delete(i,i+1);
                len--;
            }
        }
    }


    public static String ReverseWords(String str) {
        String result = null;
        if (str != null) {
            result = ""; str += "|";
            String[] word = str.split(" ");
            for (int i = word.length - 1; i > 0; i--) {
                if (i == word.length - 1 && word[i].equals("|")) { result += " "; }
                else  { result = result + word[i] + " "; }
            }
            if (word[0] == "") { result += " "; }
            result += word[0];
        }
        return result;
    }

    private static long ConvertHexToDecInt(String str) {
        long count = 0;
        long multiple = 1;
        for (int i = 7; i >= 0; i--) {
            count += (str.charAt(i) - '0') * multiple;
            multiple *= 16;
        }
        return count;
    }

    public static String ConvertHEXtoDECinString(String str) {
        String result = null;
        if (str != null) {
            long count = 0;
            int end;
            String[] without0x = str.split("0x");
            result = without0x[0];
            for (int i = 1; i < without0x.length; i++) {
                count = ConvertHexToDecInt(without0x[i].substring(0, 8));
                end = without0x[i].length();
                result = result + count + without0x[i].substring(8, end);
            }
        }
        return result;
    }
}
