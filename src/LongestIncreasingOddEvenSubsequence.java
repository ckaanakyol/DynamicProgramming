import java.util.Arrays;

public class LongestIncreasingOddEvenSubsequence {


    public static void main(String argc[]){
        int[] arr = new int[]{ 1, 12, 2, 22,
                5, 30, 31, 14, 17, 11 };
        int n = 10;
        System.out.println("Longest Increasing Odd"
                + " Even Subsequence: "
                + longOddEvenIncSeq(arr, n));
    }

    private static int longOddEvenIncSeq(int[] arr, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        for(int i = 1; i < n ; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1 && arr[i] + arr[j] % 2 != 0)
                    dp[i] = dp[j] + 1;
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
