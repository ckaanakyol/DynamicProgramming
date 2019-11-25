public class Factorial {
    final int MAX = 100;
    int res[] = new int[MAX];
    void init(){
        for(int i = 0; i < MAX; i++)
            res[i] = -1;
    }
    int factRec(int n){
        if(n <= 1)
            return 1;
        return factRec(n-1) * n;
    }

    int factDPTabulation(int n){
        res[0] = 1;
        for(int i = 1; i < n+1; i++)
            res[i] = i * res[i-1];
        return res[n];
    }
    int factDPMemoization(int n){
        if( n == 0)
            return 1;
        if(res[n] != -1)
            return res[n];
        return res[n] = factDPMemoization(n-1) * n;
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        int testnumber = 6;
        System.out.println("Recursive solution: " + f.factRec(testnumber));
        f.init();
        System.out.println("DP-Tabulation solution: " + f.factDPTabulation(testnumber));
        f.init();
        System.out.println("DP-Memoization solution: " + f.factDPMemoization(testnumber));
    }
}
