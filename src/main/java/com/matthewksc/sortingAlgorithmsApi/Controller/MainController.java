package com.matthewksc.sortingAlgorithmsApi.Controller;


import com.matthewksc.sortingAlgorithmsApi.Services.AlgorithmService;
import com.matthewksc.sortingAlgorithmsApi.dao.Algorithm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MainController {

    private AlgorithmService algorithmService;

    public MainController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping("/main")
    public ResponseEntity<List<Algorithm>> getAllResults() {

        /*for javascript connection we need to add cors headers,
        and for that we need to use responseEntity to setup
        proper header to get connection
        */
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin",
                "http://127.0.0.1:5500"); //headerValue set up to your front application
        return ResponseEntity.ok()
                .headers(headers)
                .body(algorithmService.findAll());
    }
}
