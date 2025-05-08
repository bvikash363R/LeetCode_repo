// https://leetcode.com/problems/majority-element/description/

import java.util.HashMap;

public class MajorityElement_169 {
    public static int majorityEle(int[] arr) {

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int idx : arr) {
            count.put(idx, count.getOrDefault(idx, 0) + 1);
        }

        int majority = arr[0];
        int max = 0;

        for (int i : count.keySet()) {
            if (count.get(i) > max) {
                max = count.get(i);
                majority = i;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityEle(nums));

    }
}
