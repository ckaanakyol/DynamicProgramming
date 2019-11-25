public class NSWPrime {

    static int nswpRec(int n){
        if(n <= 1)
            return 1;
        return 2 * nswpRec(n-1) + nswpRec(n-2);
    }
    static int nswpDP(int n){
        int arr[] = new int[n +1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n + 1; i++)
            arr[i] = arr[i-2] + 2*arr[i-1];
        return arr[n];
    }

    static int nswpDPv2(int n){
        int pprev = 1;
        int prev = 1;
        int last = 0;
        for(int i = 2; i < n + 1; i++) {
            last = pprev + 2 * prev;
            pprev = prev;
            prev = last;
        }
        return last;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(nswpRec(n));
        System.out.println(nswpDP(n));
        System.out.println(nswpDPv2(n));
    }
}
