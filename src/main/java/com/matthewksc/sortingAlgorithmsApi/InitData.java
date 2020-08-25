package com.matthewksc.sortingAlgorithmsApi;

import com.matthewksc.sortingAlgorithmsApi.Services.AlgorithmService;
import com.matthewksc.sortingAlgorithmsApi.Services.SortingAlgorithms;
import com.matthewksc.sortingAlgorithmsApi.dao.Algorithm;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class InitData {

    //size of array depend on personal penchant
    private static int arraySize=100000;
    private SortingAlgorithms sortingAlgorithms;
    private AlgorithmService algorithmService;

    public InitData(AlgorithmService algorithmService, SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.algorithmService = algorithmService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){
        Timer timer = new Timer();  //creating timer instance

        Algorithm bubbleSort= new Algorithm("Bubble Sort"); //bubbleSorting with big array's may take long
        bubbleSort.setTimeOfExecution(sortingAlgorithms
                .bubbleSort(createArray()));    //setting time with returning value form method bubbleSort

        Algorithm selectionSort = new Algorithm("Selection Sort");
        selectionSort.setTimeOfExecution(sortingAlgorithms
                .selectionSort(createArray())); //same setting as in example above

        Algorithm insertSort= new Algorithm("Insert Sort");
        insertSort.setTimeOfExecution(sortingAlgorithms
                .insertSort(createArray())); //same setting as in example above

        Algorithm quickSort= new Algorithm("Quick Sort");
        int[] quickSortArray = createArray();   //creating new array here
        timer.startTimer();                     //starting timer here because quicksort method do not return value
        sortingAlgorithms.quicksort(quickSortArray,
                0, quickSortArray.length-1);    //setting array also starting and ending points
        quickSort.setTimeOfExecution(timer.getTime());   //getting time for Timer instance

        Algorithm mergeSort = new Algorithm("Merge Sort");
        int[] mergeSortArray= createArray();    //creating new array here
        timer.startTimer();                     //starting timer here because quicksort method do not return value
        sortingAlgorithms.mergeSort(mergeSortArray,
                0, mergeSortArray.length-1);    //setting array also starting and ending points
        mergeSort.setTimeOfExecution(timer.getTime()); //getting time for Timer instance

        algorithmService.saveAll(Arrays.asList(
                bubbleSort, selectionSort,
                insertSort, quickSort, mergeSort));  //saving all Algorithm instance's to SQL Database


        System.out.println("Arrays Sorted api Ready!!!"); //showing ending of all sorting methods
    }

    //method to create random array for every sorting method
    //we can create array once and copy to new instance for every algorithm (Optional)
    public int[] createArray(){
        int[] Array = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            Array[i] = (int) ((Math.random()*10)+10);
        }
        return Array;
    }
}
