
/*
PROBLEM STMT:

Count ways to make sum of odd and even indexed elements equal by removing an array element

Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from
these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
1 <= n <= 10^5
-10^5 <= A[i] <= 10^5

 */


package sclr.d9.prefixsum;

public class OddEvenIndexSum {

    public static void main(String[] args){

        //int[] A = {2, 5, 7, 8, 9};
        //int[] A = {1,1,1};
        int[] A = {2,1,6, 4};
        System.out.println(solve(A));

    }

    /**
     *
     * @param A
     * @return
     *
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */
    public static int solve(int[] A){

        int sizeA = A.length;
        int[] ePS = new int[sizeA];
        int[] oPS = new int[sizeA];

        if(sizeA==1) return 0;
        if(sizeA==2) return 0;

        ePS[0] = 0;
        oPS[0] = A[0];

        oPS[1] = A[0];
        ePS[1] = A[1];


        for(int i=2; i<sizeA; i++){
            if((i+1) %2 == 0) {
                ePS[i] = ePS[i - 1] + A[i];
                oPS[i] = oPS[i-1];
            }
            else {
                oPS[i] = oPS[i-1] + A[i];
                ePS[i] = ePS[i-1];
            }
        }

        int count = 0;
        long sumE = 0L;
        long sumO = 0L;

        for(int i=0; i<sizeA; i++){

            if(i==0){
                sumE = oPS[sizeA-1] - oPS[0];
                sumO = ePS[sizeA -1] - ePS[0];
            }
            else{
                sumE = ePS[i-1] + (oPS[sizeA-1] - oPS[i]);
                sumO = oPS[i-1] + (ePS[sizeA-1] - ePS[i]);
            }
            if(sumE == sumO) count++;

        }

        return count;

    }
}
