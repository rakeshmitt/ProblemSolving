
/*
Problem Description
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.


Problem Constraints
1 <= N <= 10^5

1 <= B <= N

-10^3 <= A[i] <= 10^3

Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you removed.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4
 */

package sclr.d9.prefixsum;

public class PickBothSide {

    public static void main(String[] args){
        int[] A = {5, -2, 3, 1, 2};
        int B= 3;

        System.out.print(solve(A, B));
    }

    /*
    Time Complexity - O(n)
    Space Complexity - O(1)
     */
    public static int solve(int[] A, int B){
        int sum = 0;

        int n = A.length;



        for(int i=0; i<B; i++){
            sum += A[i];
        }
        int currSum = sum;
        int k = 0;

        int j = B -1 ;
        for(int i=n-1; i >= n-B; i--){
            currSum = currSum - A[j];
            currSum = currSum + A[i];
            j--;

            if(currSum > sum) sum = currSum;
        }

        return sum;
    }

}
