public class Fibonacci {
    final int MAX = 100;
    final int NIL = -1;
    int lookup[] = new int[MAX];

    void init(){
        for(int i = 0; i < MAX; i++)
            lookup[i] = NIL;
    }

    int fibRec(int n){
        if(n <= 1)
            return n;
        else
            return fibRec(n-1) + fibRec(n-2);
    }

    int fibDPMemoized(int n){
        if(lookup[n] == NIL) {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fibDPMemoized(n - 1) + fibDPMemoized(n - 2);
        }
        return lookup[n];
    }
    int fibDPTabulation(int n){
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < n + 1; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.init();
        System.out.println("Recursive result: " + f.fibRec(40));
        System.out.println("DP-Memoized result: " + f.fibDPMemoized(40));
        System.out.println("DP-Tabulation result: " + f.fibDPTabulation(40));
    }
}
