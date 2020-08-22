package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InitData {

    private AlgorithmService algorithmService;

    public InitData(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){

    }
}
