public class Bell {

    int computeSRec(int n, int k){
        if(n == k)
            return 1;
        if(n == 0 && k == 0)
            return 1;
        if(k == 0)
            return 0;
        if(k == 1)
            return 1;
        return k*computeSRec(n-1,k) + computeSRec(n-1,k-1);
    }
    int bellNumberRec(int n){
        if(n == 0)
            return 1;
        int res = 0;
        for(int i = 0; i <= n; i++)
            res += computeSRec(n,i);
        return res;
    }

    int computeSDP(int n, int k){
        int s[][] = new int[n+1][k+1];
        s[0][0] = 1;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= Math.min(i,k); j++){
                if( j == i)
                    s[i][j] = 1;
                else if (j == 0)
                    s[i][j] = 0;
                else
                    s[i][j] = j * s[i-1][j] + s[i-1][j-1];
            }
        }
        return s[n][k];
    }

    int bellNumberDP(int n){
        if(n == 0)
            return 1;
        int res = 0;
        for(int i = 0; i <= n; i++)
            res += computeSDP(n,i);
        return res;
    }

    int bellNumberDPv2(int n){
        int bell[][] = new int[n+1][n+1];
        bell[0][0] = 1;

        for(int i = 1; i< n+1; i++){
            bell[i][0] = bell[i-1][i-1];
            for(int j = 1; j <= i; j++)
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
        }
        return bell[n][0];
    }


    public static void main(String[] args) {
        Bell b = new Bell();
        int testnumber = 8;
        System.out.println("Recursive solution: " + b.bellNumberRec(testnumber));
        System.out.println("DP solution: " + b.bellNumberDP(testnumber));
        System.out.println("DPv2 solution: " + b.bellNumberDPv2(testnumber));
    }
}
