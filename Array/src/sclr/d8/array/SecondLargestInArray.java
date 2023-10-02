/***
 Problem Description
 You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


 Problem Constraints
 1 <= |A| <= 105

 0 <= A[i] <= 109



 Input Format
 The first argument is an integer array A.



 Output Format
 Return the second largest element. If no such element exist then return -1.



 Example Input
 Input 1:

 A = [2, 1, 2]
 Input 2:

 A = [2]


 Example Output
 Output 1:

 1
 Output 2:

 -1


 Example Explanation
 Explanation 1:

 First largest element = 2
 Second largest element = 1
 Explanation 2:

 There is no second largest element in the array.
 ***/

package sclr.d8.array;

public class SecondLargestInArray {

    public static void main(String[] args){

        int[] A = {2};

        System.out.println("2nd largest element in array " + solve(A));
    }

    public static int solve(int[] A){

        int max = A[0];
        int max2 = -1;

        for(int i=1; i<A.length; i++){
            int temp = max;
            if(A[i] > max) max = A[i];
            if(temp > max2 && temp != max) max2=temp;
            if(A[i] < max && max2 < A[i]) max2 = A[i];
        }
        return max2;
    }
}
