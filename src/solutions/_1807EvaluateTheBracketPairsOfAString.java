package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1807EvaluateTheBracketPairsOfAString {
    static public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> pair : knowledge) {
            dict.put(pair.get(0), pair.get(1));
        }

        StringBuilder out = new StringBuilder(s.length());
        StringBuilder key = new StringBuilder();
        boolean inKey = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                inKey = true;
                key.setLength(0);
            } else if (c == ')') {
                inKey = false;
                out.append(dict.getOrDefault(key.toString(), "?"));
            } else if (inKey) {
                key.append(c);
            } else {
                out.append(c);
            }
        }

        return out.toString();
    }
}
