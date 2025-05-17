public class MinCostClimbingStairs_746 {
    public static int costClimbing(int[] cost) {
        int cost_1 = cost[0];
        int cost_2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int total = cost[i] + Math.min(cost_1, cost_2);

            cost_1 = cost_2;
            cost_2 = total;
        }

        return Math.min(cost_1, cost_2);
    }

    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(costClimbing(cost));
    }
}
