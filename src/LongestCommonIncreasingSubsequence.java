import java.util.Arrays;

public class LongestCommonIncreasingSubsequence {
    public static void main(String[] args) {
        int arr1[] = {3, 4, 9, 1};
        int arr2[] = {5, 3, 8, 9, 10, 2, 1};

        int n = arr1.length;
        int m = arr2.length;

        System.out.println("Length of LCIS is " +
                LCIS(arr1, n, arr2, m));
    }

    private static int LCIS(int[] arr1, int n, int[] arr2, int m) {

        int dp[] = new int[m];
        for(int i = 0; i < n; i++){
            int current = 0;
            for(int j = 0; j < m; j++){
                if(arr1[i] == arr2[j] && current + 1 > dp[j])
                    dp[j] = current + 1;
                if(arr1[i] > arr2[j] && dp[j] > current)
                    current = dp[j];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
