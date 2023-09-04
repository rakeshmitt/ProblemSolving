/*
PROBLEM Statement


You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.


Input 1:
A = [-7, 1, 5, 2, -4, 3, 0]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:
3
Output 2:
-1

 */



package sclr.d9.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class equilibriumIndex {

    public static void main(String[] args){
        int[] A = {2, 3, 5, 8, -3};
        //int[] A = {2, 3, 5, 8, -3, 5};
        //int[] A = {2};
        //int[] A = {2, 1};
        System.out.println("SOLVE1: " + solve1(A));
        System.out.println("SOLVE2: " + solve2(A));
        System.out.println("SOLVE3: " + solve3((ArrayList<Integer>)Arrays.stream(A).boxed().collect(Collectors.toList())));
    }


    /*

    time complexity =  O(n)
      space complexity = O(n)
    */

    public static int solve1(int[] A){


        if(A.length==0) return -1;
        if(A.length==1) return 0;

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];


        for(int i=1; i<A.length; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        for(int i=0; i<A.length; i++){
            long lSum = 0L;
            long rSum = 0L;

            if(i==0){
                lSum = 0;
                rSum = prefixSum[A.length-1] - prefixSum[i];
            }
            else if(i==A.length - 1){
                lSum = prefixSum[i-1];
                rSum = 0;
            }
            else {
                lSum = prefixSum[i-1];
                rSum = prefixSum[A.length - 1] - prefixSum[i];
            }

            if(lSum==rSum) return i;
        }
        return -1;

    }


    /*
    A = {2, 3, 5, 8, -3}

    sum1= 15

    iter1: sum1= 15-2 = 13
           13 != 0.
           sum2 = 2
    iter2: sum1 = 13-3= 10
           10 != 2
           sum2 = 2+3 = 5

    iter3: sum1 = 10-5 = 5
           5==5 => i = 2

      time complexity =  O(n)
      space complexity = O(1)
    */

    public static int solve2(int[] A){

        long sum1 = 0L;

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++){
            sum1 += A[i];
        }

        long sum2 = 0L; // sum of the lower index

        for(int i=0; i<A.length; i++){
            sum1 -= A[i];

            if(sum1 == sum2){
                ans = i;
                break;
            }
            sum2 += A[i];

            if(ans == Integer.MAX_VALUE) ans = -1;
        }

        return ans;
    }

    /*

    time complexity =  O(n)
      space complexity = O(n)
    */

    public static int solve3(ArrayList<Integer> A){


        if(A.size()==0) return -1;
        if(A.size()==1) return 0;

        ArrayList<Integer> prefixSum = new ArrayList<Integer>();
        prefixSum.add(0, A.get(0));


        for(int i=1; i<A.size(); i++){
            prefixSum.add(i, prefixSum.get(i-1) + A.get(i));
        }

        for(int i=0; i<A.size(); i++){
            long lSum = 0L;
            long rSum = 0L;

            if(i==0){
                lSum = 0;
                rSum = prefixSum.get(A.size()-1) - prefixSum.get(i);
            }
            else if(i==A.size() - 1){
                lSum = prefixSum.get(i-1);
                rSum = 0;
            }
            else {
                lSum = prefixSum.get(i-1);
                rSum = prefixSum.get(A.size() - 1) - prefixSum.get(i);
            }

            if(lSum==rSum) return i;
        }
        return -1;

    }

}
