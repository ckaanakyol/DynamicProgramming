public class NCSequence {

    static int ncsRec(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return ncsRec(ncsRec(n-1)) + ncsRec(n- ncsRec(n-1));
    }
    static int ncsDP(int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i < n + 1; i++){
            arr[i] = arr[arr[i-1]] + arr[i - arr[i-1]];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(ncsRec(n));
        System.out.println(ncsDP(n));
    }
}
