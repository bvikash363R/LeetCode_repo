// https://leetcode.com/problems/missing-number/description/

import java.util.*;

public class MissingNumber_268 {

    // Approach --> 1 ---> Using Sorting technique
    public static int missingNums(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums.length;
    }

    // Approach --> 2 ---> Sum technique
    public static int sum_tech_missingNums(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int totalSum = n * (n + 1) / 2;
        for (int num : nums)
            sum += num;

        return totalSum - sum;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        System.out.println(missingNums(nums));
        System.out.println(sum_tech_missingNums(nums));
    }

}
