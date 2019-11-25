public class FriendsPairing {

    static int pairCountRec(int n){
        if( n > 2)
            return pairCountRec(n-1) + (n-1)*pairCountRec(n-2);
        else
            return n;
    }

    static  int pairCountDP(int n){
        int count[] = new int[n+1];
        for(int i = 0; i <= n; i++) {
            if( i > 2)
                count[i] = count[i - 1] + (i - 1) * count[i - 2];
            else
                count[i] = i;
        }
        return count[n];
    }
    public static void main(String[] args) {
        int n =3;

        System.out.println("Recursive: " + pairCountRec(n));
        System.out.println("DP: " + pairCountDP(n));
    }
}
