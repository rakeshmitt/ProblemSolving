package sclr.d8.array;

import java.util.HashSet;

public class GoodPair {

    public static void main(String[] args){
        int[] A = {1, 2, 3, 4};
        int B = 7;

        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B){


        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                int sum = A[i] + A[j];
                if(sum==B)
                    return 1;
            }
        }

        return 0;
    }
}
