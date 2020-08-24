package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

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

        Algorithm bubbleSort= new Algorithm("Bubble Sort");
        bubbleSort.setTimeOfExecution(sortingAlgorithms.bubbleSort(createArray()));
        algorithmService.save(bubbleSort);

        Algorithm selectionSort = new Algorithm("Selection Sort");
        selectionSort.setTimeOfExecution(sortingAlgorithms.selectionSort(createArray()));
        algorithmService.save(selectionSort);

        Algorithm insertSort= new Algorithm("Insert Sort");
        insertSort.setTimeOfExecution(sortingAlgorithms.insertSort(createArray()));
        algorithmService.save(insertSort);

        Algorithm quickSort= new Algorithm("Quick Sort");
        int[] quickSortArray = createArray();
        start = System.currentTimeMillis();
        sortingAlgorithms.quicksort(quickSortArray, 0, quickSortArray.length-1);
        end = System.currentTimeMillis();
        System.out.println(end-start);
        quickSort.setTimeOfExecution(end-start);
        algorithmService.save(quickSort);

        Algorithm mergeSort = new Algorithm("Merge Sort");
        int[] mergeSortArray= createArray();
        start = System.currentTimeMillis();
        sortingAlgorithms.mergeSort(mergeSortArray, 0, mergeSortArray.length-1);
        end = System.currentTimeMillis();
        System.out.println(end-start);
        mergeSort.setTimeOfExecution(end-start);
        algorithmService.save(mergeSort);
    }

    public int[] createArray(){
        int[] Array = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            Array[i] = (int) ((Math.random()*10)+10);
        }
        return Array;
    }
}
