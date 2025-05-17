import java.util.Arrays;

public class ClimbingStairs_70 {
    public static int climbingStairs(int n, int[] ways) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = climbingStairs(n - 1, ways) + climbingStairs(n - 2, ways);
        return ways[n];
    }

    public static int climbingStairs(int n) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);

        return climbingStairs(n, ways);

    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(5));
    }
}
