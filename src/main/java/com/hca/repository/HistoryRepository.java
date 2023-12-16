package com.hca.repository;

import com.hca.model.Author;
import com.hca.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query(value = "SELECT * FROM history", nativeQuery = true)
    List<History> getHistory();
}
