public class AddtoN {
    final int MAX = 100;
    int sum[] = new int[100];
    void init(){
        for(int i = 0; i < MAX; i++)
            sum[i] = -1;
    }
    int addToNDPMemoized(int n){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(sum[n] != -1)
            return sum[n];
        else{
            sum[n] = addToNDPMemoized(n-1) + addToNDPMemoized(n-3) + addToNDPMemoized(n-5);
            return sum[n];
        }
    }
    int addToNDPTabulation(int n){
        sum[0] = 1;

        for(int i = 1; i <= n; i++){
            if(i >= 5)
                sum[i] = sum[i-1] + sum[i-3] + sum[i-5];
            else if(i >= 3)
                sum[i] = sum[i-1] + sum[i-3];
            else if(i >= 1)
                sum[i] = sum[i-1];
        }
        return sum[n];
    }
    int addToNRec(int n){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        return addToNRec(n-1) + addToNRec(n-3)+ addToNRec(n-5);
    }
    public static void main(String[] args) {
        AddtoN a = new AddtoN();
        int testNumber = 2;
        System.out.println("Recursive solution: " + a.addToNRec(testNumber));
        a.init();
        System.out.println("DP-Memoized solution: " + a.addToNDPMemoized(testNumber));
        a.init();
        System.out.println("DP-Tabulation solution: " + a.addToNDPTabulation(testNumber));
    }
}
