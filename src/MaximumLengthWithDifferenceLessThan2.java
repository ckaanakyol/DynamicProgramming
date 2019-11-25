import java.util.Arrays;

public class MaximumLengthWithDifferenceLessThan2 {

    private static int maxLenSub(int[] arr, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(Math.abs(arr[i] - arr[j]) < 2 && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
        int n = arr.length;
        System.out.println("Maximum length subsequence = "+
                maxLenSub(arr, n));
    }


}
