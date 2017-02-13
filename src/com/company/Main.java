package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
     private static int sumA ;
     private static int sumB ;


     private static int matrix[][];
     private static int diagonal1 =0;
     private static int diagonal2 =0;

    public static void main(String[] args) {
//        sumArrayFromInput();
//        tripleteChallenge();
//        veryBigSum();
//        diagonalDifference();
//        leftRotation();

//todo check statement
//        minFraction();
        return;
    }

//    ============================LEFT  ROTACION============================================

    private static void leftRotation() {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int leftRotation = in.nextInt();
        int array[] = new int[size];
        int i ;
        fillArray(in, size, array);
        in.close();
        StringBuffer buffer =new StringBuffer("");
        fillOutputBuffer(size, leftRotation, array, buffer);
        System.out.println(buffer);
    }

    private static void fillOutputBuffer(int size, int leftRotation, int[] array, StringBuffer buffer) {
        for (int index = 0; index  < size ; index++){
            int pos = (index + leftRotation) % size;
            buffer.append(array[pos]);
            buffer.append(" ");
        }
    }

    private static void fillArray(Scanner in, int size, int[] array) {
        int i;
        for(i = 0 ; i < size; i++){
            array[i]= in.nextInt();
        }
    }

//    ===================================================minFraction================================================

    private static void minFraction() {
        Scanner in = new Scanner(System.in);

        double denominator = in.nextDouble();
        double nPositives =0;
        double nNegatives = 0;
        double nNeutral = 0;
        int aux;

        while (in.hasNext()){
            aux = in.nextInt();
            if (aux < 0){
                nNegatives++;
            }else if(aux == 0 ) {
                nNeutral++;
            }else {
                nPositives ++;
            }
        }


        System.out.println((double) nPositives/denominator);
        System.out.println((double) nNeutral/denominator);
        System.out.println((double) nNegatives/denominator);
    }

    //    ===========================DIAGONAL DIFF ==================================================
    private static void diagonalDifference() {
        Scanner in = new Scanner(System.in);
        int tam = in.nextInt();
        fillMatrix(in, tam);
        diagonal1=0;
        diagonal2=0;
        sumDiagonalOne(tam);
        sumDiagonalSecond(tam);

        System.out.println(Math.abs(diagonal1 - diagonal2));
    }

    private static void sumDiagonalSecond(int tam) {
        for(int j = tam-1, i = 0; i < tam; i++  ){
            diagonal2 += matrix[i][j-i];
        }
    }

    private static void sumDiagonalOne(int tam) {
        for (int i = 0 ; i< tam; i++){
            diagonal1 += matrix[i][i];
        }
    }

    private static void fillMatrix(Scanner in, int tam) {
        matrix = new int[tam][tam];
        for(int i = 0; i<  tam ; i++){
            for (int j= 0; j< tam; j++){
                matrix[i][j] = in.nextInt();
            }
        }
    }


//    ===========================bigSum================================
    /**
     * You are given an array of integers of size . You need to print the sum of the elements in the array, keeping in mind that some of those integers may be quite large.

     Input Format

     The first line of the input consists of an integer . The next line contains  space-separated integers contained in the array.

     Output Format
     Print a single value equal to the sum of the elements in the array.
     */
    private static void veryBigSum() {
        Scanner in = new Scanner(System.in);
        int nNumbers = in.nextInt();
        long longSum= 0;
        for(int i= 0 ; i< nNumbers; i++){
          longSum += in.nextLong();
        }
        System.out.println(longSum);
    }


    //    =============================================   TRIPLETE ==============================================

    private static void tripleteChallenge() {
        int tripleteA[] = new int[3];
        int tripleteB[] = new int[3];
        compareTripletes(tripleteA, tripleteB);
    }

    private static void compareTripletes(int[] tupleA, int[] tupleB) {
        sumA = 0;
        sumB = 0;
        readTuples(tupleA, tupleB);
        evaluateTuples(tupleA, tupleB);
        System.out.println(sumA +" "+sumB);
    }

    private static void evaluateTuples(int[] tupleA, int[] tupleB) {
        for(int i = 0 ; i< 3 ; i++){
            compareNumbers(tupleA[i],tupleB[i]);
        }
    }

    private static void readTuples(int[] tupleA, int[] tupleB) {
        Scanner in = new Scanner(System.in);
        int n =0;
        while (n<6){
            if(n< 3) {
                tupleA[n] =in.nextInt();
            }
            else {
                tupleB[n%3] =in.nextInt();
            }
            n++;
        }
    }


    private  static void compareNumbers(int a , int b){
        if (a > b){
            sumA ++;
        }
        else if (b > a){
            sumB ++;
        }
    }
//    =============================================  END TRIPLETE ==============================================

    /**
     *  n = tarray size
     *  {numbers}
     */
    private static void sumArrayFromInput() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println( sumArray(in, n, arr));
    }

    private static int sumArray(Scanner in, int n, int[] arr) {
        int sum = 0;
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
            sum += arr[arr_i];
        }
        return sum;
    }
}
