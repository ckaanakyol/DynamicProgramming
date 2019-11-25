public class CuttingRod {

    static int cutRodRec(int price[], int n){
        if(n <= 0)
            return  0;
        int max_val = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++){
            max_val = Math.max(max_val, price[i] + cutRodRec(price, n - i - 1));
        }
        return max_val;
    }

    static int cutRodDP(int price[], int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        for(int i = 1; i < n + 1; i++){
            int max_val = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                max_val = Math.max(max_val, price[j] + arr[i-j-1]);
                arr[i] = max_val;
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Recursive solution "+  cutRodRec(arr, size));
        System.out.println("DP solution "+  cutRodDP(arr, size));
    }
}
