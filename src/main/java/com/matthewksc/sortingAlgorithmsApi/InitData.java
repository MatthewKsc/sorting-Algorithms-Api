package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitData {

    private static int arraySize=1000;
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
    }

    public int[] createArray(){
        int[] Array = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            Array[i] = (int) ((Math.random()*10)+10);
        }
        return Array;
    }
}
