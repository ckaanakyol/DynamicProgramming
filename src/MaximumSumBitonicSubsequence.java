public class MaximumSumBitonicSubsequence {

    private static int MaxSumBS(int[] arr, int n) {
        int dpi[] = new int[n];
        int dpd[] = new int[n];
        for(int i = 0; i < n; i++){
            dpi[i] = arr[i];
            dpd[i] = arr[i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dpi[i] < dpi[j] + arr[i])
                    dpi[i] = dpi[j] + arr[i];
            }
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(arr[i] > arr[j] && dpd[i] < dpd[j] + arr[i])
                    dpd[i] = dpd[j] + arr[i];
            }
        }

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max_sum = Math.max(max_sum, (dpd[i] + dpi[i] - arr[i]));
        return max_sum;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
        int n = arr.length;
        System.out.println("Maximum Sum : " + MaxSumBS(arr, n));
    }
}
