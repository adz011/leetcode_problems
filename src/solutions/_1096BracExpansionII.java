package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _1096BracExpansionII {
    static public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(new Parser(expression).parseUnion());
    }

    private static class Parser {
        private final String expression;
        private int pos = 0;

        Parser(String expression) {
            this.expression = expression;
        }

        Set<String> parseUnion() {
            Set<String> words = new TreeSet<>(parseConcat());
            while (pos < expression.length() && expression.charAt(pos) == ',') {
                pos++;
                words.addAll(parseConcat());
            }
            return words;
        }

        Set<String> parseConcat() {
            Set<String> words = new TreeSet<>();
            words.add("");
            while (pos < expression.length()
                    && expression.charAt(pos) != ','
                    && expression.charAt(pos) != '}') {
                Set<String> next = parseFactor();
                Set<String> product = new TreeSet<>();
                for (String prefix : words) {
                    for (String suffix : next) {
                        product.add(prefix + suffix);
                    }
                }
                words = product;
            }
            return words;
        }

        Set<String> parseFactor() {
            if (expression.charAt(pos) == '{') {
                pos++;
                Set<String> inner = parseUnion();
                pos++; // consume the matching '}'
                return inner;
            }
            Set<String> letter = new TreeSet<>();
            letter.add(String.valueOf(expression.charAt(pos++)));
            return letter;
        }
    }
}
