// https://leetcode.com/problems/total-characters-in-string-after-transformations-ii

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Transformations_II_3337 {

    private static final int ALPHA = 26;
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // 1) Build the 26×26 transition matrix M,
        // where M[i][j] = count of times 'a'+j appears when 'a'+i transforms once.
        long[][] M = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            int cnt = nums.get(i);
            for (int k = 1; k <= cnt; k++) {
                int j = (i + k) % ALPHA;
                M[i][j] = 1;
            }
        }

        // 2) Compute M^t via fast exponentiation
        long[][] Mt = matrixPower(M, t);

        // 3) v0 is the vector of length-1 contributions: v0[j] = 1 for all j
        // vt = Mt * v0 ⇒ vt[i] = sum_j Mt[i][j]
        long[] vt = new long[ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            long sum = 0;
            for (int j = 0; j < ALPHA; j++) {
                sum = (sum + Mt[i][j]) % MOD;
            }
            vt[i] = sum;
        }

        // 4) Finally, sum vt[c] over each character c in s
        long ans = 0;
        for (char ch : s.toCharArray()) {
            ans = (ans + vt[ch - 'a']) % MOD;
        }
        return (int) ans;
    }

    // Fast exponentiation of a square matrix A to the power e
    private long[][] matrixPower(long[][] A, long e) {
        // Initialize result = I (identity)
        long[][] res = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            res[i][i] = 1;
        }
        long[][] base = A;

        while (e > 0) {
            if ((e & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            e >>= 1;
        }
        return res;
    }

    // Multiply two ALPHA×ALPHA matrices, mod MOD
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            for (int k = 0; k < ALPHA; k++)
                if (A[i][k] != 0) {
                    long a = A[i][k];
                    for (int j = 0; j < ALPHA; j++) {
                        C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                    }
                }
        }
        return C;
    }

    public static void main(String[] args) {

        Transformations_II_3337 obj = new Transformations_II_3337();

        String s = "abcyy";
        int t = 2;
        List<Integer> nums = new ArrayList<>(
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2));

        System.out.println(obj.lengthAfterTransformations(s, t, nums));

    }

}
