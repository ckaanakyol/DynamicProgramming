import java.util.Arrays;

public class GoldMine {

    static int getMaxGold(int[][] arr, int m,int n){
        int goldTable[][] = new int[m][n];
        for(int[] rows:goldTable)
            Arrays.fill(rows, 0);

        for(int col = n-1; col >= 0; col--){
            for(int row = 0; row < m; row++){
                int right = (col == n - 1) ? 0 : goldTable[row][col + 1];
                int right_down = (col == n-1) || (row == m - 1) ? 0 : goldTable[row+1][col+1];
                int right_up = (col == n-1) || (row == 0) ? 0 : goldTable[row-1][col+1];

                goldTable[row][col] = arr[row][col] + Math.max(right, Math.max(right_down, right_up));
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++)
            if(goldTable[i][0] > res)
                res = goldTable[i][0];
        return res;
    }
    public static void main(String[] args) {
        int gold[][]= {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        int m = 4, n = 4;

        System.out.print(getMaxGold(gold, m, n));
    }
}
