public class MdBSequence {

    static int rec(int n){
        if( n == 0)
            return 0;
        if( n == 1)
            return 1;

        return (n % 2 == 0) ? 4 * rec(n/2) : 4 * rec((n-1)/2) + 1;
    }

    static int dp(int n){
        int arr[] = new int[ n + 1 ];

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < n + 1; i++){
            if(i % 2 == 0)
                arr[i] = 4 * arr[n/2];
            else
                arr[i] = 4 * arr[(n-1)/2] + 1;
        }
        return arr[n];
    }

    public static void moserDeBruijnRec(int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(rec(i) + " ");
        System.out.println();
    }

    public static void moserDeBruijnDP(int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(rec(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println("First " + n +
                " terms of " +
                "Moser-de Bruijn Sequence : ");
        moserDeBruijnRec(n);
        moserDeBruijnDP(n);
    }
}
