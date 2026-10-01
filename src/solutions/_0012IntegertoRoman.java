package solutions;

import java.util.List;

public class _0012IntegertoRoman {
    List<romanValue> lookupTable = buildRomanLookupTable();

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int numberCopy = num;
        for (romanValue rv : lookupTable) {
            int value = rv.value;
            while (numberCopy >= value) {
                sb.append(rv.s);
                numberCopy -= value;
            }
        }
        return sb.toString();
    }

    private List<romanValue> buildRomanLookupTable() {
        return List.of(
                new romanValue(1000, "M"),
                new romanValue(900, "CM"),
                new romanValue(500, "D"),
                new romanValue(400, "CD"),
                new romanValue(100, "C"),
                new romanValue(90, "XC"),
                new romanValue(50, "L"),
                new romanValue(40, "XL"),
                new romanValue(10, "X"),
                new romanValue(9, "IX"),
                new romanValue(5, "V"),
                new romanValue(4, "IV"),
                new romanValue(1, "I")
        );
    }

    record romanValue(int value, String s){};
}
