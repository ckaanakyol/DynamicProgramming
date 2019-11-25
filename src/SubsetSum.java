public class SubsetSum {

    static boolean isSubsetSumRec(int[] set, int size, int sum){
        if(sum == 0)
            return true;
        if(size == 0 && sum != 0)
            return false;
        if(set[size -1] > sum)
            return isSubsetSumRec(set, size-1, sum);
        return isSubsetSumRec(set, size-1, sum) || isSubsetSumRec(set, size-1, sum-set[size-1]);
    }

    static boolean isSubsetSumDP(int[] set, int size, int sum){
        boolean arr[][] = new boolean[size + 1][sum + 1] ;

        for (int i = 0; i <= size; i++)
            arr[i][0] = true;

        for (int i = 1; i <= sum; i++)
            arr[0][i] = false;

        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= sum; j++){
                if( j >= set[i-1])
                    arr[i][j] = arr[i-1][j-set[i-1]] || arr[i-1][j];
                else
                    arr[i][j] = arr[i-1][j];
            }
        }
        return arr[size][sum];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        System.out.print("Recursive: ");
        if (isSubsetSumRec(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
        System.out.print("DP: ");
        if (isSubsetSumDP(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}
