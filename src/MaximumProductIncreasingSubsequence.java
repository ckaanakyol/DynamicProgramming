import java.util.Arrays;

public class MaximumProductIncreasingSubsequence {

    private static int lis(int []arr, int n){
        int []dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = arr[i];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] * arr[i])
                    dp[i] = dp[j] * arr[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args) {
        int[] arr = { 3, 100, 4, 5, 150, 6 };
        int n = arr.length;

        System.out.println(lis(arr, n));
    }
}
