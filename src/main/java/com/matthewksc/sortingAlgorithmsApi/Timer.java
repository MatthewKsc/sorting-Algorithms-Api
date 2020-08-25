package com.matthewksc.sortingAlgorithmsApi;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Timer {

    private long start;
    private long end;

    public Timer() {
    }

    public void startTimer(){
        start= System.currentTimeMillis();
    }

    public long getTime(){
        end = System.currentTimeMillis();
        return end-start;
    }
}
