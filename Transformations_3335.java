// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description
public class Transformations_3335 {

    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        int[][] dp = new int[26][2]; // dp[char][current/previous]

        // Base case: after 0 transformations, each char contributes 1
        for (int i = 0; i < 26; i++) {
            dp[i][0] = 1;
        }

        // DP for t transformations
        for (int i = 1; i <= t; i++) {
            for (int c = 0; c < 26; c++) {
                if (c == 25) { // 'z' becomes 'a' + 'b'
                    dp[c][i % 2] = (dp[0][(i - 1) % 2] + dp[1][(i - 1) % 2]) % MOD;
                } else {
                    dp[c][i % 2] = dp[c + 1][(i - 1) % 2];
                }
            }
        }

        // Compute final length
        long total = 0;
        for (char ch : s.toCharArray()) {
            total = (total + dp[ch - 'a'][t % 2]) % MOD;
        }

        return (int) total;
    }

    public static void main(String[] args) {
        Transformations_3335 sol = new Transformations_3335();
        String s = "abcyy";
        int t = 2;
        System.out.println(sol.lengthAfterTransformations(s, t));
    }
}
