/***
 * Problem Description
 * Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.
 *
 * Problem Constraints
 * 1 <= N <= 106
 * 1 <= A[i] <=108
 * 1 <= B <= 109
 *
 * Input Format
 * There are 2 lines in the input
 *
 * Line 1: The first number is the size N of the array A. Then N numbers follow which indicate the elements in the array A.
 *
 * Line 2: A single integer B.
 *
 * Output Format
 * Print array A after rotating it B times towards the right.
 *
 * Example Input
 * Input 1 :
 * 4 1 2 3 4
 * 2
 *
 * Example Output
 * Output 1 :
 * 3 4 1 2
 *
 * Example Explanation
 * Example 1 :
 *
 * N = 4, A = [1, 2, 3, 4] and B = 2.
 *
 * Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
 *
 * Final array = [3, 4, 1, 2]
 */

package sclr.d8.array;

import java.util.Scanner;

public class RotateGame {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] inputArray = new int[n];

        for(int i=0; i<n; i++){
            inputArray[i] = input.nextInt();
        }

        int B = input.nextInt();

        if(B > n) B %= n;

        inputArray = reverseArray(inputArray, 0, n-1);
        inputArray = reverseArray(inputArray, 0, B-1);
        inputArray = reverseArray(inputArray, B, n-1);

        for(int i =0; i<n; i++){
            System.out.print(inputArray[i] + " ");
        }
    }

    private static int[] reverseArray(int[] A, int start, int end){

        int i = start;
        int j = end;

        while(i < j){

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

            i++;
            j--;
        }
        return A;
    }


}
