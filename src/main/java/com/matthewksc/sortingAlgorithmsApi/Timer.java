package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.context.annotation.Configuration;

@Configuration
//class for timing execution of sorting algorithms
public class Timer {

    //variables
    private long start;
    private long end;

    public Timer() {
    }

    //starting timer
    public void startTimer(){
        start= System.currentTimeMillis();
    }

    //get time of execution
    public long getTime(){
        end = System.currentTimeMillis();
        return end-start;
    }
}
