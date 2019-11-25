public class UglyNumbers {

    int maxDivide(int a, int b){
        while( a % b == 0)
            a = a/b;
        return a;
    }
    boolean isUgly(int a){
        a = maxDivide(a, 2);
        a = maxDivide(a, 3);
        a = maxDivide(a, 5);

        return a == 1;
    }
    int getNthUglyNoNaive(int n){
        int i = 1;
        int count = 1;

        while(n > count){
            i++;
            if(isUgly(i))
                count++;
        }
        return i;
    }

    int getNthUglyNoDP(int n){
        int ugly[] = new int[n];
        ugly[0] = 1;
        int i2 =0 , i3 = 0, i5 = 0;
        int next_m2 = 2;
        int next_m3 = 3;
        int next_m5 = 5;

        for(int i = 1; i < n; i++){
            ugly[i] = Math.min(next_m2, Math.min(next_m3,next_m5));

            if(ugly[i] == next_m2){
                i2++;
                next_m2 = ugly[i2] * 2;
            }
            if(ugly[i] == next_m3){
                i3++;
                next_m3 = ugly[i3] * 3;
            }
            if(ugly[i] == next_m5){
                i5++;
                next_m5 = ugly[i5] * 5;
            }
        }
        return ugly[n-1];
    }
    public static void main(String[] args) {
        UglyNumbers u = new UglyNumbers();
        int testnumber = 150;
        System.out.println("Naive solution: " + u.getNthUglyNoNaive(testnumber));
        System.out.println("DP solution: " + u.getNthUglyNoDP(testnumber));
    }
}
