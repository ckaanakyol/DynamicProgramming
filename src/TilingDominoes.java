public class TilingDominoes {

    // 3 * n board with 1x2 dominoes
    static int countWays(int n){
        int A[] = new int[n+1];
        int B[] = new int[n+1];
        A[0] = 1;
        A[1] = 0;
        B[0] = 0;
        B[1] = 1;

        for(int i = 2; i < n + 1; i++){
            A[i]= A[i-2] + 2 * B[i-1];
            B[i] = A[i-1] + B[i-2];
        }
        return A[n];
    }

    // n x m board with 1xm dominoes
    static int countWays(int n, int m){
        int arr[] = new int[n + 1];
        arr[0] = 0;

        for(int i = 0; i <= n; i++){
            if( i > m )
                arr[i] = arr[i - m] + arr[i - 1];
            else if (i < m)
                arr[i] = 1;
            else
                arr[i] = 2;
        }
        return arr[n];
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(countWays(n));

        n = 7;
        int m = 4;
        System.out.println("Number of ways = "
                + countWays(n, m));
    }
}
