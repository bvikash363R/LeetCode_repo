import java.util.ArrayList;
import java.util.List;

public class AdjacentSubsequence_2900 {

    /**
     * Returns one of the longest alternating subsequences of words
     * such that adjacent words come from different groups.
     */
    public List<String> longestUnequalAdjacentGroupsSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;

        // Always take the first word
        ans.add(words[0]);
        int lastBit = groups[0];

        // Greedily take words[i] whenever groups[i] != lastBit
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastBit) {
                ans.add(words[i]);
                lastBit = groups[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AdjacentSubsequence_2900 sol = new AdjacentSubsequence_2900();

        String[] words1 = { "e", "a", "b" };
        int[] groups1 = { 0, 0, 1 };
        System.out.println(sol.longestUnequalAdjacentGroupsSubsequence(words1, groups1));
        // possible output: [e, b]

        String[] words2 = { "a", "b", "c", "d" };
        int[] groups2 = { 1, 0, 1, 1 };
        System.out.println(sol.longestUnequalAdjacentGroupsSubsequence(words2, groups2));
        // possible output: [a, b, c]
    }

}
