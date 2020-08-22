package com.matthewksc.sortingAlgorithmsApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Algorithm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private Long timeOfExecution;

    public Algorithm() {
    }

    public Algorithm(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimeOfExecution() {
        return timeOfExecution;
    }

    public void setTimeOfExecution(Long timeOfExecution) {
        this.timeOfExecution = timeOfExecution;
    }
}
