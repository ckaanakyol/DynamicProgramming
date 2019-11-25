import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    static int maxSumIS(int arr[], int n){
        int dp[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++)
            dp[i] = arr[i];

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i])
                    dp[i] = dp[j] + arr[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum "+
                "increasing subsequence is "+
                maxSumIS(arr, n));
    }
}
