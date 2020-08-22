package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitData {

    private static int arraySize=30;
    private SortingAlgorithms sortingAlgorithms;
    private AlgorithmService algorithmService;

    public InitData(AlgorithmService algorithmService, SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.algorithmService = algorithmService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){

    }

    public int[] createArray(){
        int[] Array = new int[arraySize];
        for (int i=0; i<arraySize; i++){
            Array[i] = (int) ((Math.random()*10)+10);
        }
        return Array;
    }
}
