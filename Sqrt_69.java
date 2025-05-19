public class Sqrt_69 {
    public static int mySqrt(int n) {
        if (n < 2) {
            return n;
        }

        int left = 1, right = n / 2, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == n) {
                return mid;
            } else if (square < n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }

}
