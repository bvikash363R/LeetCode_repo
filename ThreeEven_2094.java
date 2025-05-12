// https://leetcode.com/problems/finding-3-digit-even-numbers

import java.util.Set;
import java.util.TreeSet;

class ThreeEven_2094 {

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] freq = new int[10]; // digit frequency

        for (int digit : digits) {
            freq[digit]++;
        }

        // Try all combinations of i (hundreds), j (tens), k (ones)
        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--; // use i as hundreds

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0)
                    continue;
                freq[j]--; // use j as tens

                for (int k = 0; k <= 9; k += 2) { // only even ones
                    if (freq[k] == 0)
                        continue;

                    int num = i * 100 + j * 10 + k;
                    result.add(num);
                }

                freq[j]++; // backtrack
            }

            freq[i]++; // backtrack
        }

        // Convert set to int[]
        int[] res = new int[result.size()];
        int index = 0;
        for (int num : result) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] digits = { 2, 2, 8, 8, 2 };

        int[] result = findEvenNumbers(digits);
        for (int idx : result) {
            System.out.print(idx + " ");
        }
    }
}
