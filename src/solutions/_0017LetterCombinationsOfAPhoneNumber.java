package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class _0017LetterCombinationsOfAPhoneNumber {
    static List<String> allCombinations = new ArrayList<>();
    static List<List<Character>> lookupTable;

    static public List<String> letterCombinations(String digits) {
        lookupTable = new ArrayList<>();
        buildLookupTable();
        helper(new StringBuilder(), 0, digits);
        return allCombinations;
    }


    static private void buildLookupTable() {
        lookupTable.add(List.of('a', 'b', 'c'));
        lookupTable.add(List.of('d', 'e', 'f'));
        lookupTable.add(List.of('g', 'h', 'i'));
        lookupTable.add(List.of('j', 'k', 'l'));
        lookupTable.add(List.of('m', 'n', 'o'));
        lookupTable.add(List.of('p', 'q', 'r', 's'));
        lookupTable.add(List.of('t', 'u', 'v'));
        lookupTable.add(List.of('w', 'x', 'y', 'z'));
    }

    static private void helper(StringBuilder s, int i, String digits) {
        if (i == digits.length()) {
            allCombinations.add(s.toString());
        } else {
            List<Character> currList = lookupTable.get(digits.charAt(i) - '0' - 2);
            for (Character c : currList) {
                s.append(c);
                helper(s, i + 1, digits);
                s.deleteCharAt(i);
            }
        }
    }
}
