public class Catalan {

    int findNthCatalanRec(int n){
        int res = 0;
        if(n == 0)
            return 1;

        for(int i = 0; i < n; i++)
            res += findNthCatalanRec(i) * findNthCatalanRec(n - i - 1);
        return  res;
    }

    int findNthCatalanDP(int n){
        int catalan[] = new int[n+2];
        catalan[0] = 1;
        catalan[1] = 1;

        for(int i = 2; i < n + 2; i++){
            catalan[i] = 0;
            for(int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j];
        }
        return catalan[n+1];
    }

    public static void main(String[] args) {
        Catalan c = new Catalan();
        int testnumber = 10;
        System.out.println("Recursive solution: " + c.findNthCatalanRec(testnumber));
        System.out.println("DP-Tabulation solution: " + c.findNthCatalanDP(testnumber));

    }
}
