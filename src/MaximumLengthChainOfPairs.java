import java.util.Arrays;

public class MaximumLengthChainOfPairs {
     static class Pair{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25),
                new Pair (27, 40), new Pair(50, 60)};
        System.out.println("Length of maximum size chain is " +
                maxChainLength(arr, arr.length));
    }

    private static int maxChainLength(Pair[] arr, int n) {
         int dp[] = new int[n];
         Arrays.fill(dp,1);

         for(int i = 0; i < n; i++){
             for(int j = 0; j < i; j++){
                 if(arr[i].a > arr[j].b && dp[i] < dp[j] + 1)
                     dp[i] = dp[j] + 1;
             }
         }
         return Arrays.stream(dp).max().getAsInt();
    }
}

