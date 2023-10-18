package com.hca.repository;

import com.hca.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Chapter, Long> {
}
