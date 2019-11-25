import java.util.Arrays;

public class LongestBitonicSubsequence {
    static int lbs(int arr[], int n){
        int dpi[] = new int[n];
        Arrays.fill(dpi,1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dpi[i] < dpi[j] + 1)
                    dpi[i] = dpi[j] + 1;
            }
        }

        int dpd[] = new int[n];
        Arrays.fill(dpd,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] < arr[j] && dpd[i] < dpd[j] + 1)
                    dpd[i] = dpd[j] + 1;
            }
        }
        int max = dpd[0] + dpi[0] - 1;
        for(int i = 1; i < n; i++)
            if(dpd[i] + dpi[i] - 1 > max)
                max = dpd[i] + dpi[i] - 1;
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is "+ lbs( arr, n ));
    }
}
