package com.matthewksc.sortingAlgorithmsApi.dao;

import com.matthewksc.sortingAlgorithmsApi.dao.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmRepo extends JpaRepository<Algorithm, Long> {
}
