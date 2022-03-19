package io.dmitryerikin.leetcode.algorithms.romantointeger;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private final static Map<String, Integer> a = new HashMap<>();

    static {
        a.put("I", 1);
        a.put("IV", 4);
        a.put("V", 5);
        a.put("IX", 9);
        a.put("X", 10);
        a.put("XL", 40);
        a.put("L", 50);
        a.put("XC", 90);
        a.put("C", 100);
        a.put("CD", 400);
        a.put("D", 500);
        a.put("CM", 900);
        a.put("M", 1000);
    }

    public int romanToInt(String s) {
        int l = s.length();
        // current position
        int c = 0;
        int result = 0;

        // until reach the end of the roman
        while (c < l) {
            // if last index then exactly one character else the next numeral can be two-character
            String curr = c + 2 <= l ? s.substring(c, c + 2) : "0";
            // check that next two-character numeral can be found in map
            if (a.containsKey(curr)) {
                // if so value added to the result
                result += a.get(curr);
                // and move position by 2
                c += 2;
            } else {
                // else numeral is one-digit and value is added to the result
                result += a.get(String.valueOf(s.charAt(c)));
                // and move position by 1
                c++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert 3 == solution.romanToInt("III");
        System.out.println(solution.romanToInt("III"));

        assert 58 == solution.romanToInt("LVIII");
        System.out.println(solution.romanToInt("LVIII"));

        assert 1994 == solution.romanToInt("MCMXCIV");
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
