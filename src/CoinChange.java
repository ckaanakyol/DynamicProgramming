import java.util.Arrays;

public class CoinChange {

    static int coinChangeCountRec(int S[], int m, int n){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        if(m <= 0 && n >= 1)
            return 0;

        return coinChangeCountRec(S, m-1, n) + coinChangeCountRec(S, m, n-S[m-1]);
    }
    static int coinChangeCountDP(int S[], int m, int n){
        int count[] = new int[n+1];
        Arrays.fill(count, 0);
        count[0] = 1;

        for(int coin : S){
            for(int amount = coin; amount <= n; amount++){
                count[amount] += count[amount - coin];
            }
        }
        return count[n];
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        int m = arr.length;
        int n = 12;
        System.out.println("Recursive: " + coinChangeCountRec(arr, m, n));
        System.out.println("DP: " + coinChangeCountDP(arr, m, n));
    }
}
