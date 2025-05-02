// https://leetcode.com/problems/max-consecutive-ones/description/

class MaxConsecutiveOnes_485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currsum = 0;
        int maxsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currsum++;
                if (currsum > maxsum) {
                    maxsum = currsum;
                }
            } else {
                currsum = 0;
            }

        }
        return maxsum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
