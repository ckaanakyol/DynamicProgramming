import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int max_ref;
    static int lisRec(int arr[], int n){
        if(n == 1)
            return 1;

        int res, max_ending_here = 1;

        for(int i = 1; i < n; i++){
            res = lisRec(arr, i);
            if(arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }

        if(max_ref < max_ending_here)
            max_ref = max_ending_here;
        return max_ending_here;
    }

    static int lisDP(int arr[], int n){
        int lis[] = new int[n+1];
        int max = 0;
        Arrays.fill(lis, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    static int lis(int arr[], int n){
        max_ref = 1;
        lisRec( arr, n);
        return max_ref;
    }
    public static void main(String args[]){
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Recursive Solution: " + lis(arr, n));
        System.out.println("DP Solution: " + lisDP(arr, n));
    }
}
