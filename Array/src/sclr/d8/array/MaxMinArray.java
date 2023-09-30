package sclr.d8.array;

import java.util.Scanner;

public class MaxMinArray {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] A = new int[size];

        for(int i=0; i<size; i++){
            A[i] = in.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<size; i++){
            if(max < A[i]) max = A[i];
            if(min > A[i]) min = A[i];
        }

        System.out.println(max + " " + min);
    }
}
