import java.util.Arrays;

public class MaximumSumIncreasingFromIndexIncludeNumber {
    public static void main(String[] args) {
        int a[] = { 1, 101, 2, 3, 100, 4, 5 };
        int n = a.length;
        int index = 4, k = 6;
        System.out.println(
                pre_compute(a, n, index, k));
    }

    private static int pre_compute(int[] a, int n, int index, int k) {
        int dp[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(a[i] > k)
                dp[i] = 0;
            else if(i < index)
                dp[i] = 0;
            else
                dp[i] = a[i];
        }

        for(int i = index; i < n; i++){
            for(int j = index; j < i; j++){
                if(a[i] > a[j] && a[i] <= k && dp[i] < dp[j] + a[i])
                    dp[i] = dp[j] + a[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
