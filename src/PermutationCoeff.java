public class PermutationCoeff {

    int permutationCoeffRec(int n, int k){
        if(k == 0)
            return 1;
        if( k > n)
            return 0;
        return permutationCoeffRec(n-1,k) + k * permutationCoeffRec(n-1,k-1);
    }

    int permutationCoeffDP(int n, int k){
        int perm[][] = new int[n+2][k+2];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= Math.min(i,k); j++){
                if(j == 0)
                    perm[i][j] = 1;
                else
                    perm[i][j] = perm[i-1][j] + j * perm[i-1][j-1];

                //perm[i][j+1] = 0;
            }
        }
        return perm[n][k];
    }
    int permutationCoeffDPv2(int n, int k){
        int fact[] = new int[n+1];
        fact[0] = 1;

        for(int i = 1; i <= n; i++){
            fact[i] = fact[i-1] * i;
        }
        return fact[n] / fact[n-k];
    }

    int permutationCoeffOptimal(int n, int k){
        int fn = 1;
        int fk = 1;
        for(int i = 1; i <= n; i++){
            fn = fn * i;
            if(i == n - k)
                fk = fn;
        }
        return fn / fk;
    }

    public static void main(String[] args) {
        PermutationCoeff p = new PermutationCoeff();
        int t1 = 10, t2 = 2;
        System.out.println("Recursive solution: " + p.permutationCoeffRec(t1,t2));
        System.out.println("DP solution: " + p.permutationCoeffDP(t1,t2));
        System.out.println("DPv2 solution: " + p.permutationCoeffDPv2(t1,t2));
        System.out.println("Optimal solution: " + p.permutationCoeffOptimal(t1,t2));
    }
}
