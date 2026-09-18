package solutions;

import java.util.ArrayList;
import java.util.List;

public class _1520MaximumNumberofNonOverlappingSubstrings {
    static public List<String> maxNumOfSubstrings(String s) {
        List<Pair> validCandidates = new ArrayList<>();
        int n = s.length();
        int[][] bound = new int[27][2];
        for (int i = 1; i < 27; i++) {
            bound[i][0] = -1;
            bound[i][1] = -1;
        }
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) & 31;
            if (bound[c][0] == -1) {
                bound[c][0] = i;
            }
            bound[c][1] = i;
        }
        for (int i = 1; i < 27; i++) {
            if (bound[i][0] == -1) continue;
            int left = bound[i][0], pos = bound[i][0] + 1, right = bound[i][1];
            boolean foundCandidate = true;
            while (pos <= right) {
                int middleChar = s.charAt(pos) & 31;
                if (bound[middleChar][0] < left) {
                    foundCandidate = false;
                    break;
                }
                if (bound[middleChar][1] > right) right = bound[middleChar][1];
                pos++;
            }
            if (foundCandidate) validCandidates.add(new Pair(left, right));
        }
        List<Pair> finalPairs = new ArrayList<>();
        for (Pair x : validCandidates) {
            boolean collides = false;
            for (Pair y : finalPairs) {
                if ((x.right >= y.left && x.left <= y.right)) {
                    collides = true;
                    int yLength = y.right - y.left + 1;
                    int xLength = x.right - x.left + 1;
                    if (xLength < yLength) {
                        finalPairs.remove(y);
                        finalPairs.add(x);
                        break;
                    }
                }
            }
            if (!collides) finalPairs.add(x);
        }
        List<String> answer = new ArrayList<>();
        for (Pair x : finalPairs) {
            answer.add(s.substring(x.left, x.right + 1));
        }
        return answer;

    }

    record Pair(int left, int right) {
    }
}
