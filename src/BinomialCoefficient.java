public class BinomialCoefficient {

    int binomialCoeffRec(int n, int k){
        if(k == 0 || k == n)
            return 1;
        return binomialCoeffRec(n-1,k) + binomialCoeffRec(n-1,k-1);
    }

    int binomialCoeffDP(int n, int k){
        int C[][] = new int[n+1][k+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= Math.min(i,k); j++){
                if( j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i-1][j] + C[i-1][j-1];
            }
        }
        return C[n][k];
    }

    int binomialCoeffDPv2(int n, int k){
        int C[] = new int[k+1];
        C[0] = 1;

        for(int i = 0; i <=n; i++){
            for(int j = Math.min(i,k) ; j > 0 ; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];
    }

    public static void main(String[] args) {
        BinomialCoefficient b = new BinomialCoefficient();
        int t1 = 6, t2 = 2;
        System.out.println("Recursive solution: " + b.binomialCoeffRec(t1,t2));
        System.out.println("DP solution: " + b.binomialCoeffDP(t1,t2));
        System.out.println("DP solution v2: " + b.binomialCoeffDPv2(t1,t2));
    }
}
