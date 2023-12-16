package com.hca.repository;

import com.hca.model.Comic;
import com.hca.model.ComicContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Long> {
    @Query(value = "CALL HCA_COMIC_GET_COMIC;", nativeQuery = true)
    List<Comic> getAllTruyen();

}
