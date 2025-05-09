import java.util.HashMap;

public class SingleNumber_136 {
    public static int singleNumber(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx : nums) {
            map.put(idx, map.getOrDefault(idx, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
    }
}
