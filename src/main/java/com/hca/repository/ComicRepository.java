package com.hca.repository;

import com.hca.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {
}
