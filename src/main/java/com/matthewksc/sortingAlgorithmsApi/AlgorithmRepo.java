package com.matthewksc.sortingAlgorithmsApi;

import com.matthewksc.sortingAlgorithmsApi.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlgorithmRepo extends JpaRepository<Long, Algorithm> {
}
