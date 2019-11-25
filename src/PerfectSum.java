import java.util.ArrayList;

public class PerfectSum {
    static boolean arr[][];
    static void printAllSubsets(int set[], int size, int sum){
        if (size == 0 || sum < 0)
            return;

        arr = new boolean[size][sum + 1] ;

        for (int i = 0; i < size; i++)
            arr[i][0] = true;

        if (set[0] <= sum)
            arr[0][set[0]] = true;


        for(int i = 1; i < size; i++){
            for(int j = 0; j <= sum; j++){
                if( j >= set[i])
                    arr[i][j] = arr[i-1][j-set[i]] || arr[i-1][j];
                else
                    arr[i][j] = arr[i-1][j];
            }
        }
        if(!arr[size-1][sum])
            System.out.println("There are no subsets with" +
                    " sum "+ sum);
        else{
            ArrayList<Integer> p = new ArrayList<>();
            printSubsetsRec(set, size-1, sum, p);
        }
    }

    static void printSubsetsRec(int set[], int i, int sum, ArrayList<Integer> p){
        if (i == 0 && sum != 0 && arr[0][sum])
        {
            p.add(set[i]);
            display(p);
            p.clear();
            return;
        }
        if (i == 0 && sum == 0)
        {
            display(p);
            p.clear();
            return;
        }
        if (arr[i-1][sum])
        {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(set, i-1, sum, b);
        }
        if (sum >= set[i] && arr[i-1][sum-set[i]])
        {
            p.add(set[i]);
            printSubsetsRec(set, i-1, sum-set[i], p);
        }
    }

    static void display(ArrayList<Integer> v)
    {
        System.out.println(v);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int sum = 10;
        printAllSubsets(arr, n, sum);
    }
}
