package com.matthewksc.sortingAlgorithmsApi;


import org.springframework.stereotype.Service;

@Service
public class SortingAlgorithms {

    public long bubbleSort(int[] arr){
        long start = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++){
            for (int y=0; y<arr.length-1; y++){
                if (arr[y]>arr[y+1]){
                    swap(y, y+1, arr);
                }
            }
        }
        long end = System.currentTimeMillis();
        //System.out.println(end-start);
        return end-start;
    }
//    public int[] selectionSort(int[] arr){
//    }
//    public int[] insertSort(int[] arr){
//    }
//    public int[] quicksort(int arr[], int left, int right){
//    }
//    public int[] mergeSort(int arr[],int lo, int n){
//    }

    public void swap(int leftIndex, int rightIndex, int[] arr){
        int temp = arr[leftIndex];
        arr[leftIndex]= arr[rightIndex];
        arr[rightIndex]= temp;
    }
}
