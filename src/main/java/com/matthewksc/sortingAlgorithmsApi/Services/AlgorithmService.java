package com.matthewksc.sortingAlgorithmsApi.Services;

import com.matthewksc.sortingAlgorithmsApi.dao.Algorithm;
import com.matthewksc.sortingAlgorithmsApi.dao.AlgorithmRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlgorithmService {

    private AlgorithmRepo algorithmRepo;

    public AlgorithmService(AlgorithmRepo algorithmRepo) {
        this.algorithmRepo = algorithmRepo;
    }

    public List<Algorithm> findAll() {
        return algorithmRepo.findAll();
    }

    public <S extends Algorithm> List<S> saveAll(Iterable<S> iterable) {
        return algorithmRepo.saveAll(iterable);
    }

    public <S extends Algorithm> S save(S s) {
        return algorithmRepo.save(s);
    }

    public Optional<Algorithm> findById(Long aLong) {
        return algorithmRepo.findById(aLong);
    }
}
