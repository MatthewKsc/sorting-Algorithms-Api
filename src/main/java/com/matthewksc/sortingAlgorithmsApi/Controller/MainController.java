package com.matthewksc.sortingAlgorithmsApi.Controller;


import com.matthewksc.sortingAlgorithmsApi.Services.AlgorithmService;
import com.matthewksc.sortingAlgorithmsApi.dao.Algorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private AlgorithmService algorithmService;

    public MainController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping("/main")
    public Iterable<Algorithm> getAllResults(){
        return algorithmService.findAll();
    }
}
