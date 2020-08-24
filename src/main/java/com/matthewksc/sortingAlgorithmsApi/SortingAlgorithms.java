package com.matthewksc.sortingAlgorithmsApi;


import org.springframework.stereotype.Service;

@Service
public class SortingAlgorithms {

    //Timer timer = new Timer();

    //bubbleSort
    public long bubbleSort(int[] arr){
        long start = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++){
            for (int y=0; y<arr.length-1; y++){
                if (arr[y]>arr[y+1]) swap(y, y+1, arr);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return end-start;
    }

    //selectionSort
    public long selectionSort(int[] arr){
        long start = System.currentTimeMillis();
        for (int i=0;i <arr.length; i++){
            int min=i;
            for (int y=i; y<arr.length; y++){
                if (arr[min]> arr[y]) min=y;
            }
            swap(i, min, arr);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return end-start;
    }

    //insertSort
    public long insertSort(int[] arr){
        long start = System.currentTimeMillis();
        for (int i=1; i<arr.length; i++){
            int j=i;
            int holder = arr[i];
            while (j>0 && arr[j-1]>holder){
                arr[j]= arr[j-1];
                j--;
            }
            arr[j]= holder;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return end-start;
    }

    //quickSort
    public void quicksort(int[] arr, int left, int right){
        if (left>=right){
            return ;
        }
        int pivot = arr[(left+right)/2];
        int index = partition(arr, left, right, pivot);
        quicksort(arr, left, index-1);
        quicksort(arr, index, right);
    }

    private int partition(int[] arr, int left, int right, int pivot){
        while (left<= right){
            while (arr[left]<pivot){
                left++;
            }

            while (arr[right]>pivot){
                right--;
            }
            if (left<=right){
                swap(left, right, arr);
                left++;
                right--;
            }
        }
        return left;
    }

    //mergeSort
    public void mergeSort(int arr[],int lo, int n){
        int low = lo;
        int high = n;

        if (low>=high){
            return;
        }

        int middle = (low + high)/2;

        mergeSort(arr,low, middle);
        mergeSort(arr,middle+1, high);

        int low_end = middle;
        int high_start= middle +1;

        while ((lo<=low_end)&&(high_start<=high)){
            if (arr[low] < arr[high_start]){
                low++;
            }else {
                int temp = arr[high_start];
                for (int k=high_start-1; k>=low; k--){
                    arr[k+1]= arr[k];
                }
                arr[low] =temp;
                low++;
                low_end++;
                high_start++;
            }
        }
    }

    public void swap(int leftIndex, int rightIndex, int[] arr){
        int temp = arr[leftIndex];
        arr[leftIndex]= arr[rightIndex];
        arr[rightIndex]= temp;
    }
}
