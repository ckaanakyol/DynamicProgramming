import java.util.Arrays;

public class nCrModp {

    static int comv1(int n, int r, int p){
        int arr[] = new int[n+1];
        Arrays.fill(arr, 1);
        for(int i = 1; i < n+1; i++){
            arr[i] = i * arr[i-1];
        }
        return (arr[n] / (arr[r] * arr[ n -r])) % p;
    }

    static int comv2(int n, int r, int p){
        int arr[] = new int[r+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = Math.min(i, r); j > 0; j--){
                arr[j] = (arr[j] + arr[j-1])%p;
            }
        }
        return arr[r];
    }
    public static void main(String[] args) {
        int t1 = 10, t2 = 2, t3 = 13;
        System.out.println("DP solution: " + comv1(t1, t2, t3));
        System.out.println("DP solution: " + comv2(t1, t2, t3));
    }

}
