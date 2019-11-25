import java.util.Arrays;

public class PaintingFence {

    static long countWays(int n, int k) {

        long dp[] = new long[n + 1];
        Arrays.fill(dp, 0);
        int mod = 1000000007;
        dp[1] = k;

        int same = 0;
        int diff = k;
        int total = k;

        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (int)total * ( k - 1 );
            diff = diff % mod;

            total = (same + diff) % mod;
        }

        return total;

    }
    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(countWays(n, k));
    }


}
