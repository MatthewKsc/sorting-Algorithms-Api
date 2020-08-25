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

    private static int arraySize=100000;
    private long start;
    private long end;
    private SortingAlgorithms sortingAlgorithms;
    private AlgorithmService algorithmService;

    public InitData(AlgorithmService algorithmService, SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.algorithmService = algorithmService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){

        Timer timer = new Timer();

        Algorithm bubbleSort= new Algorithm("Bubble Sort");
        bubbleSort.setTimeOfExecution(sortingAlgorithms.bubbleSort(createArray()));

        Algorithm selectionSort = new Algorithm("Selection Sort");
        selectionSort.setTimeOfExecution(sortingAlgorithms.selectionSort(createArray()));

        Algorithm insertSort= new Algorithm("Insert Sort");
        insertSort.setTimeOfExecution(sortingAlgorithms.insertSort(createArray()));

        Algorithm quickSort= new Algorithm("Quick Sort");
        int[] quickSortArray = createArray();
        timer.startTimer();
        sortingAlgorithms.quicksort(quickSortArray, 0, quickSortArray.length-1);
        quickSort.setTimeOfExecution(timer.getTime());

        Algorithm mergeSort = new Algorithm("Merge Sort");
        int[] mergeSortArray= createArray();
        timer.startTimer();
        sortingAlgorithms.mergeSort(mergeSortArray, 0, mergeSortArray.length-1);
        mergeSort.setTimeOfExecution(timer.getTime());

        algorithmService.saveAll(Arrays.asList(
                bubbleSort, selectionSort, insertSort, quickSort, mergeSort
        ));
        System.out.println("Arrays Sorted api Ready!!!");
    }

    public int[] createArray(){
        int[] Array = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            Array[i] = (int) ((Math.random()*10)+10);
        }
        return Array;
    }
}
