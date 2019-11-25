public class LongestCommonSubsequence {
    static int LCSRec(char[] a, char[] b, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(a[m-1] == b[n-1])
            return 1 + LCSRec(a, b, m-1, n-1);
        else
            return Math.max(LCSRec(a,b,m,n-1), LCSRec(a,b,m-1, n));
    }

    static int LCSDP(char[] a, char[] b, char[] c, int m, int n, int o) {
        int arr[][][] = new int[m + 1][n + 1][o + 1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                for(int k = 0; k <= o; k++){
                    if (i == 0 || j == 0 || k == 0)
                        arr[i][j][k] = 0;
                    else if(a[i-1] == b[j-1] && a[i-1] == c[k-1])
                        arr[i][j][k] = 1 + arr[i-1][j-1][k-1];
                    else
                        arr[i][j][k] = Math.max(Math.max(arr[i-1][j][k], arr[i][j-1][k]), arr[i][j][k-1]);
                }
            }
        }
        return arr[m][n][o];
    }

    static int LCSDP(char[] a, char[] b, int m, int n) {
        int arr[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    arr[i][j] = 0;
                else if(a[i-1] == b[j-1])
                    arr[i][j] = 1 + arr[i-1][j-1];
                else
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
            }
        }

        int i = m, j = n;
        String res = "";
        int index = arr[m][n];
        while(i > 0 && j > 0){
            if(arr[i-1][j] == index ){
               i = i-1;
            }
            else if(arr[i][j-1] == index){
                j = j - 1;
            }
            else{
                res = a[i - 1] + res;
                i = i - 1;
                j = j - 1;
                index = arr[i][j];
            }
        }



        System.out.println(res);

        return arr[m][n];
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Recursive Solution " + LCSRec( X, Y, m, n ) );
        System.out.println("DP Solution " + LCSDP( X, Y, m, n ) );

        String A = "AGGT12100";
        String B = "12TXAYB100";
        String C = "12XBA0100";

        char[] AA=A.toCharArray();
        char[] BB=B.toCharArray();
        char[] CC=C.toCharArray();
        m = AA.length;
        n = BB.length;
        int o = CC.length;

        System.out.println("Length of LCS is " +
                LCSDP(AA, BB, CC, m, n, o));

    }
}
